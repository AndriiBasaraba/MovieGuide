package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType


@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { navController.popBackStack() },
                title = viewModel.movieTitle,
                imdbId = "123",
                detailsType = DetailsType.SHOW
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(
                text = "Movie details screen = ${viewModel.movieTitle}",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
