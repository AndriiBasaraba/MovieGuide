package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsState
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowCast
import basaraba.adndrii.movieguide.features.main.person_details.RoleType
import basaraba.adndrii.movieguide.features.orDash
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType
import basaraba.adndrii.movieguide.features.ui_components.ExpandableText
import basaraba.adndrii.movieguide.features.ui_components.ProgressBar
import basaraba.adndrii.movieguide.features.ui_components.RatingCircle
import coil.compose.AsyncImage

@Composable
fun MovieDetailsScreeUi(
    onEvent: (MovieDetailsUiEvent) -> Unit,
    viewState: MovieDetailsState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { onEvent(MovieDetailsUiEvent.Back) },
                title = viewState.movieTitle,
                imdbId = viewState.data.imdbId,
                detailsType = DetailsType.SHOW,
                isBookmarked = viewState.data.isBookmarked,
                onBookmarkClick = { onEvent(MovieDetailsUiEvent.UpdateBookmark(it)) }
            )
        }
    ) {
        if (viewState.isLoading) {
            ProgressBar()
        } else {
            val details = viewState.data

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 8.dp)
            ) {
                item {
                    MovieHeader(
                        posterUrl = details.poster,
                        voteAverage = details.voteAverage,
                    ) { url -> onEvent(MovieDetailsUiEvent.ShowImagePreview(url)) }
                }
                if (details.overview.isNotEmpty()) {
                    item {
                        ExpandableText(
                            text = details.overview,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
                if (details.images.isNotEmpty()) {
                    item {
                        Images(
                            images = details.images,
                            onClick = { url -> onEvent(MovieDetailsUiEvent.ShowImagePreview(url)) }
                        )
                    }
                }
                if (details.movieCredits.isNotEmpty()) {
                    item {
                        MovieCast(
                            details.movieCredits
                        ) { id, name ->
                            onEvent(
                                MovieDetailsUiEvent.ShowPersonDetails(
                                    id, name
                                )
                            )
                        }
                    }
                }
                if (details.recommendations.isNotEmpty()) {
                    item {
                        RecommendedMovies(details.recommendations) { id, title ->
                            onEvent(
                                MovieDetailsUiEvent.ShowMovieDetails(
                                    id, title
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MovieHeader(
    posterUrl: String,
    voteAverage: Double,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier.wrapContentSize()
        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick.invoke(posterUrl) },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
            ) {
                AsyncImage(
                    model = posterUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(160.dp)
                        .height(240.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_image_placeholder),
                    error = painterResource(id = R.drawable.ic_image_placeholder)
                )
            }
            RatingCircle(
                rating = voteAverage,
                textSize = 14.sp,
                strokeWidth = 2.dp,
                modifier = Modifier
                    .padding(start = 126.dp)
                    .size(40.dp)
                    .align(Alignment.BottomStart)
            )
        }

        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            //todo here will be info about movie
        }
    }
}

@Composable
private fun Images(
    images: List<String>,
    onClick: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        items(images) { image ->
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick.invoke(image) },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier.size(170.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_image_placeholder),
                    error = painterResource(id = R.drawable.ic_image_placeholder)
                )
            }
        }
    }
}

@Composable
private fun MovieCast(
    cast: List<ShowCast>,
    onPersonClick: ((Long, String) -> Unit)? = null
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(cast) { person ->
            Box {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .wrapContentHeight()
                        .clickable { onPersonClick?.invoke(person.id, person.name) },
                    shape = RoundedCornerShape(topStartPercent = 50, topEndPercent = 50),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
                ) {
                    Column {
                        AsyncImage(
                            model = person.avatar,
                            contentDescription = null,
                            modifier = Modifier.size(120.dp),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                            error = painterResource(id = R.drawable.ic_avatar_placeholder)
                        )
                        Text(
                            text = person.name,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp
                        )
                        Text(
                            text = stringResource(id = R.string.as_in),
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        )
                        Text(
                            text = person.role.orDash(),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 8.dp, bottom = 8.dp, end = 8.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RecommendedMovies(
    movies: List<ShowUiData>,
    onMovieClick: ((Long, String) -> Unit)? = null,
) {
    //todo fix here?
    Text(
        text = "Recommended:",
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Medium
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(movies) { credit ->
            Box {
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .wrapContentHeight()
                        .clickable { onMovieClick?.invoke(credit.id, credit.title) },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
                ) {
                    Column {
                        AsyncImage(
                            model = credit.poster,
                            contentDescription = null,
                            modifier = Modifier
                                .width(160.dp)
                                .height(220.dp),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.ic_image_placeholder),
                            error = painterResource(id = R.drawable.ic_image_placeholder)
                        )
                        Text(
                            text = credit.title,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 16.dp, top = 28.dp, end = 8.dp, bottom = 16.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp
                        )
                    }
                }
                RatingCircle(
                    rating = credit.voteAverage,
                    textSize = 16.sp,
                    strokeWidth = 3.dp,
                    modifier = Modifier
                        .padding(top = 195.dp, start = 8.dp)
                        .size(50.dp)
                        .align(Alignment.TopStart)
                )
            }
        }
    }
}
