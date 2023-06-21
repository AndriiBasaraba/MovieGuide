package basaraba.adndrii.movieguide.features.main.movies

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
    Button(
        onClick = { onEvent(MoviesUiEvent.ShowMovieDetails(Random.nextInt(0, 100))) },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Click here!!")
    }
}
