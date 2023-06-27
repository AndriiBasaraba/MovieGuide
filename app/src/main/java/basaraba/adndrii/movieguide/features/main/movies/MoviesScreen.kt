package basaraba.adndrii.movieguide.features.main.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import org.koin.androidx.compose.koinViewModel
import kotlin.random.Random

@Composable
fun MoviesScreen(
    navController: NavController,
    viewModel: MoviesViewModel = koinViewModel()
) {
    val onEvent: (MoviesUiEvent) -> Unit = { event ->
        when (event) {
            is MoviesUiEvent.ShowMovieDetails -> {
                navController.navigate(NavigationRoute.MovieDetails.getRouteNameWithArguments(event.id.toString()))
            }

            MoviesUiEvent.ReloadMoviesScreen -> {
                // ignored
            }
        }
    }
    MoviesScreenUi(onEvent = onEvent)
}

@Composable
fun MoviesScreenUi(onEvent: (MoviesUiEvent) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = stringResource(id = R.string.movies),
                        color = Color.Black
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(it)
        ) {
            Button(
                onClick = { onEvent(MoviesUiEvent.ShowMovieDetails(Random.nextLong(0, 100))) },
                modifier = Modifier
                    .padding(16.dp)
                    .size(width = 120.dp, height = 60.dp)
            ) {
                Text(text = "Click here!!", color = Color.White)
            }
        }
    }
}
