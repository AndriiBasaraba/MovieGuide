package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.BottomNavItem
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import basaraba.adndrii.movieguide.features.navigation.setDefaultBackNavigation

@Composable
fun WatchListScreen(
    navController: NavController,
    viewModel: WatchListViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()
    val onEvent: (WatchListUiEvent) -> Unit = { event ->
        when (event) {
            is WatchListUiEvent.OpenMovieDetails -> {
                navController.navigate(
                    NavigationRoute.MovieDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is WatchListUiEvent.OpenTvShowDetails -> {
                navController.navigate(
                    NavigationRoute.TvShowDetails.getRouteNameWithArguments(
                        event.id.toString(),
                        event.title
                    )
                )
            }

            is WatchListUiEvent.DeleteBookmark -> {
                viewModel.setEvent(event)
            }

            is WatchListUiEvent.OnQueryChange -> {
                viewModel.setEvent(event)
            }

            is WatchListUiEvent.OpenMovies -> {
                navController.navigate(BottomNavItem.Movies.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                }
            }

            is WatchListUiEvent.OpenTvShows -> {
                navController.navigate(BottomNavItem.TvShows.route) {
                    this.setDefaultBackNavigation(navController)
                }
            }
        }
    }

    WatchListScreenUi(onEvent = onEvent, viewState = viewState)
}
