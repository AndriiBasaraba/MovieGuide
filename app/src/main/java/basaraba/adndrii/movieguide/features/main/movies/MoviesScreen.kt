package basaraba.adndrii.movieguide.features.main.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R

@Composable
fun MoviesScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val onEvent: (MoviesUiEvent) -> Unit = { event ->
        when (event) {
            is MoviesUiEvent.ShowMovieDetails -> {
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
