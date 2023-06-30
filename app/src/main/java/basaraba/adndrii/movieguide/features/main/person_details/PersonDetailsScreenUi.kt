package basaraba.adndrii.movieguide.features.main.person_details

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import basaraba.adndrii.movieguide.features.main.person_details.model.PersonDetailsState
import basaraba.adndrii.movieguide.features.main.person_details.model.PersonDetailsUiData
import basaraba.adndrii.movieguide.features.main.person_details.model.RoleCreditsUi
import basaraba.adndrii.movieguide.features.orDash
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType
import basaraba.adndrii.movieguide.features.ui_components.ProgressBar
import basaraba.adndrii.movieguide.features.ui_components.RatingCircle
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailsScreenUi(
    onEvent: (PersonDetailsUiEvent) -> Unit,
    viewState: PersonDetailsState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { onEvent(PersonDetailsUiEvent.Back) },
                title = viewState.personName,
                imdbId = viewState.data.imdbId,
                detailsType = DetailsType.PERSON
            )
        }
    ) {
        if (viewState.isLoading) {
            ProgressBar()
        } else {
            val personDetails = viewState.data
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 8.dp)
            ) {
                item {
                    PersonHeader(personDetails = personDetails)
                }

                if (personDetails.biography.isNotEmpty()) {
                    item {
                        PersonBiography(biography = personDetails.biography)
                    }
                }
                if (personDetails.images.isNotEmpty()) {
                    item {
                        PersonImages(images = personDetails.images)
                    }
                }
                if (personDetails.movieRoles.isNotEmpty()) {
                    item {
                        PersonRoles(
                            onMovieClick = { movieId, title ->
                                onEvent(
                                    PersonDetailsUiEvent.ShowMovieDetails(
                                        movieId, title
                                    )
                                )
                            },
                            creditsRoles = personDetails.movieRoles,
                            type = RoleType.MOVIE
                        )
                    }
                }
                if (personDetails.tvShowRoles.isNotEmpty()) {
                    item {
                        PersonRoles(
                            onTvShowClick = { tvShowId, title ->
                                onEvent(
                                    PersonDetailsUiEvent.ShowTvShowDetails(
                                        tvShowId, title
                                    )
                                )
                            },
                            creditsRoles = personDetails.tvShowRoles,
                            type = RoleType.TV_SHOW
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PersonHeader(
    personDetails: PersonDetailsUiData
) {
    Row(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ) {
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            AsyncImage(
                model = personDetails.avatar,
                contentDescription = null,
                modifier = Modifier
                    .width(160.dp)
                    .height(220.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                error = painterResource(id = R.drawable.ic_avatar_placeholder)
            )
        }
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.known_for),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = personDetails.department,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            if (personDetails.placeOfBirth.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.birthplace),
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = personDetails.placeOfBirth,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (personDetails.birthday.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.date_of_birth),
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = personDetails.birthday,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
            if (personDetails.deathday.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.date_of_death),
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = personDetails.deathday,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun PersonBiography(biography: String) {
    var showMoreBiography by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .animateContentSize(animationSpec = tween(100))
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { showMoreBiography = !showMoreBiography }) {
        Text(
            text = stringResource(id = R.string.biography),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = biography,
            maxLines = if (showMoreBiography) Int.MAX_VALUE else 6,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun PersonImages(images: List<String>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(images) { image ->
            Card(
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier.size(170.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                    error = painterResource(id = R.drawable.ic_avatar_placeholder)
                )
            }
        }
    }
}

@Composable
private fun PersonRoles(
    onMovieClick: ((Long, String) -> Unit)? = null,
    onTvShowClick: ((Long, String) -> Unit)? = null,
    creditsRoles: List<RoleCreditsUi>,
    type: RoleType
) {
    Text(
        text = stringResource(
            if (type == RoleType.MOVIE) R.string.movies_count else R.string.tv_shows_count,
            creditsRoles.size
        ),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Medium
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(creditsRoles) { credit ->
            Box {
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .wrapContentHeight()
                        .wrapContentHeight()
                        .clickable {
                            if (type == RoleType.MOVIE) {
                                onMovieClick?.invoke(credit.id, credit.title)
                            } else {
                                onTvShowClick?.invoke(credit.id, credit.title)
                            }
                        },
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
                                .padding(start = 8.dp, top = 26.dp, end = 8.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = stringResource(id = R.string.as_in),
                            color = Color.Gray,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        )
                        Text(
                            text = credit.role.orDash(),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 8.dp, bottom = 8.dp, end = 8.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
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
