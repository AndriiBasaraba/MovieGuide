package basaraba.adndrii.movieguide.features.main.person_details

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.PersonDetailsUiData
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonDetailsScreen(
    navController: NavController,
    viewModel: PersonDetailsViewModel = koinViewModel()
) {
    val personName by viewModel.personName.collectAsStateWithLifecycle()
    val personDetails by viewModel.personDetailsState.collectAsStateWithLifecycle()

    val onEvent: (PersonDetailsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonDetailsUiEvent.Back -> {
                navController.popBackStack()
            }
        }
    }

    val data = personDetails.data
    if (data != null) {
        PersonDetailsScreenUi(
            onEvent = onEvent,
            personName = personName,
            personDetails = data

        )
    }
}

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
                            contentDescription = "Navigation icon"
                        )
                    }
                }
            )
        }
    ) {
        var showMore by remember { mutableStateOf(false) }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row {
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
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp)
                    ) {
                        Text(text = "Known for")
                        Text(text = personDetails.department)
                        Text(text = "Birthplace", modifier = Modifier.padding(top = 8.dp))
                        Text(text = personDetails.placeOfBirth)
                        Text(text = "Date of Birth", modifier = Modifier.padding(top = 8.dp))
                        Text(text = personDetails.birthday)
                        if (personDetails.deathday.isNotEmpty()) {
                            Text(text = "Date of Death", modifier = Modifier.padding(top = 8.dp))
                            Text(text = personDetails.deathday)
                        }
                    }
                }
            }

            item {
                Column(modifier = Modifier
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore = !showMore }) {
                    Text(text = "Biography:")
                    if (showMore) {
                        Text(text = personDetails.biography)
                    } else {
                        Text(
                            text = personDetails.biography,
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}
