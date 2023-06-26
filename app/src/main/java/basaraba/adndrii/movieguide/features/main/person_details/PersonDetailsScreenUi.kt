package basaraba.adndrii.movieguide.features.main.person_details

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.PersonDetailsUiData
import basaraba.adndrii.movieguide.features.orDash
import coil.compose.AsyncImage

@Composable
fun PersonDetailsScreenUi(
    onEvent: (PersonDetailsUiEvent) -> Unit,
    personName: String,
    personDetails: PersonDetailsUiData
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = personName,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onEvent(PersonDetailsUiEvent.Back)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        var showMore by remember { mutableStateOf(false) }
        val imageSize = (LocalConfiguration.current.screenWidthDp - 70) / 2

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
                ) {
                    AsyncImage(
                        model = personDetails.avatar,
                        contentDescription = null,
                        modifier = Modifier
                            .width(160.dp)
                            .height(220.dp)
                            .clip(RoundedCornerShape(12)),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                        error = painterResource(id = R.drawable.ic_avatar_placeholder)
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.known_for),
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W400
                        )
                        Text(
                            text = personDetails.department,
                            fontSize = 18.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.W500
                        )
                        Text(
                            text = stringResource(id = R.string.birthplace),
                            modifier = Modifier.padding(top = 8.dp),
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W400
                        )
                        Text(
                            text = personDetails.placeOfBirth,
                            fontSize = 18.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.W500
                        )
                        Text(
                            text = stringResource(id = R.string.date_of_birth),
                            modifier = Modifier.padding(top = 8.dp),
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W400
                        )
                        Text(
                            text = personDetails.birthday,
                            fontSize = 18.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.W500
                        )
                        if (personDetails.deathday.isNotEmpty()) {
                            Text(
                                text = stringResource(id = R.string.date_of_death),
                                modifier = Modifier.padding(top = 8.dp),
                                fontSize = 14.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.W400
                            )
                            Text(
                                text = personDetails.deathday,
                                fontSize = 18.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.W500
                            )
                        }
                    }
                }
            }

            item {
                Column(modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore = !showMore }) {
                    Text(
                        text = stringResource(id = R.string.biography),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = personDetails.biography,
                        maxLines = if (showMore) Int.MAX_VALUE else 6,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            if (personDetails.images.isNotEmpty()) {
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        items(personDetails.images) { image ->
                            AsyncImage(
                                model = image,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(170.dp)
                                    .clip(RoundedCornerShape(12)),
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                                error = painterResource(id = R.drawable.ic_avatar_placeholder)
                            )
                        }
                    }
                }
            }
            if (personDetails.movieRoles.isNotEmpty()) {
                item {
                    Text(
                        text = stringResource(R.string.movies_count, personDetails.movieRoles.size),
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        items(personDetails.movieRoles) { movie ->
                            Card(
                                modifier = Modifier
                                    .width(160.dp)
                                    .wrapContentHeight()
                                    .wrapContentHeight()
                                    .clickable {
                                        onEvent(PersonDetailsUiEvent.ShowMovieDetails(movie.id))
                                    },
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(0.5.dp, Color.Gray),
                                backgroundColor = Color.White,
                            ) {
                                Column {
                                    AsyncImage(
                                        model = movie.poster,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(160.dp)
                                            .height(220.dp),
                                        contentScale = ContentScale.Crop,
                                        placeholder = painterResource(id = R.drawable.ic_image_placeholder),
                                        error = painterResource(id = R.drawable.ic_image_placeholder)
                                    )
                                    Text(
                                        text = movie.title,
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 16.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.W500
                                    )
                                    Text(
                                        text = stringResource(id = R.string.as_in),
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        text = movie.role.orDash(),
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .padding(start = 8.dp, bottom = 8.dp, end = 8.dp),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 16.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.W500
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
