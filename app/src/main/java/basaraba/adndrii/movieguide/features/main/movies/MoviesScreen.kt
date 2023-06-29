package basaraba.adndrii.movieguide.features.main.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import org.koin.androidx.compose.koinViewModel

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreenUi(onEvent: (MoviesUiEvent) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colorScheme.background,
                title = {
                    Text(
                        text = stringResource(id = R.string.movies),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            Text(
                text = "here will be list of movies",
                color = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}
