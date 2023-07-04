package basaraba.adndrii.movieguide.features.main.person_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute

@Composable
fun PersonDetailsScreen(
    navController: NavController,
    viewModel: PersonDetailsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val onEvent: (PersonDetailsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonDetailsUiEvent.Back -> {
                navController.popBackStack()
            }

            is PersonDetailsUiEvent.OpenMovieDetails -> {
                navController.navigate(
                    NavigationRoute.MovieDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is PersonDetailsUiEvent.OpenTvShowDetails -> {
                navController.navigate(
                    NavigationRoute.TvShowDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is PersonDetailsUiEvent.ShowImagePreview -> {
                navController.navigate(
                    NavigationRoute.ImagePreview.getRouteNameWithArguments(event.url)
                )
            }
        }
    }

    PersonDetailsScreenUi(
        onEvent = onEvent,
        viewState = viewState
    )
}
