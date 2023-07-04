package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.main.movie_details.MovieDetailsScreeUi
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute


@Composable
fun TvShowDetailsScreen(
    navController: NavController,
    viewModel: TvShowDetailsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val onEvent: (TvShowDetailsUiEvent) -> Unit = { event ->
        when (event) {
            is TvShowDetailsUiEvent.Back -> {
                navController.popBackStack()
            }

            is TvShowDetailsUiEvent.OpenTvShowDetails -> {
                navController.navigate(
                    NavigationRoute.TvShowDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is TvShowDetailsUiEvent.ShowPersonDetails -> {
                navController.navigate(
                    NavigationRoute.PersonDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.name
                    )
                )
            }

            is TvShowDetailsUiEvent.ShowImagePreview -> {
                navController.navigate(
                    NavigationRoute.ImagePreview.getRouteNameWithArguments(event.url)
                )
            }

            is TvShowDetailsUiEvent.UpdateBookmark -> {
                viewModel.setEvent(event)
            }
        }
    }
    TvShowDetailsScreenUi(onEvent = onEvent, viewState = viewState)
}
