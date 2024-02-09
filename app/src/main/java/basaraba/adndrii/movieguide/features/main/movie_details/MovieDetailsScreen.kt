package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute


@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val onEvent: (MovieDetailsUiEvent) -> Unit = { event ->
        when (event) {
            is MovieDetailsUiEvent.Back -> {
                navController.popBackStack()
            }

            is MovieDetailsUiEvent.ShowMovieDetails -> {
                navController.navigate(
                    NavigationRoute.MovieDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is MovieDetailsUiEvent.ShowPersonDetails -> {
                navController.navigate(
                    NavigationRoute.PersonDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.name
                    )
                )
            }

            is MovieDetailsUiEvent.ShowImagePreview -> {
                navController.navigate(
                    NavigationRoute.ImagePreview.getRouteNameWithArguments(event.url)
                )
            }

            is MovieDetailsUiEvent.UpdateBookmark -> {
                viewModel.setEvent(event)
            }
        }
    }
    MovieDetailsScreeUi(onEvent = onEvent, viewState = viewState)
}
