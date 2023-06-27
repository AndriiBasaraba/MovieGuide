package basaraba.adndrii.movieguide.features.main.person_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonDetailsScreen(
    navController: NavController,
    viewModel: PersonDetailsViewModel = koinViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val onEvent: (PersonDetailsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonDetailsUiEvent.Back -> {
                navController.popBackStack()
            }

            is PersonDetailsUiEvent.ShowMovieDetails -> {
                navController.navigate(NavigationRoute.MovieDetails.getRouteNameWithArguments(event.id.toString()))
            }

            is PersonDetailsUiEvent.ShowTvShowDetails -> {
                navController.navigate(NavigationRoute.TvShowDetails.getRouteNameWithArguments(event.id.toString()))
            }
        }
    }

    PersonDetailsScreenUi(
        onEvent = onEvent,
        viewState = viewState
    )
}
