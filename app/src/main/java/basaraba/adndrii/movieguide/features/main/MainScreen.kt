package basaraba.adndrii.movieguide.features.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.main.movies.MoviesScreen
import basaraba.adndrii.movieguide.features.main.peoples.PeoplesScreen
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute


@Composable
fun MainScreen(
    navController: NavController
) {
    val onEvent: (MainUiEvent) -> Unit = { event ->
        when (event) {
            MainUiEvent.NavigateBack -> {
                navController.navigate(NavigationRoute.Close.route)
            }

            is MainUiEvent.ShowMovieDetail -> {
                navController.navigate(NavigationRoute.MovieDetails.getRouteNameWithArguments(event.id.toString()))
            }

            is MainUiEvent.ShowPeopleDetail -> {
                navController.navigate(NavigationRoute.PeopleDetails.getRouteNameWithArguments(event.id.toString()))
            }

            MainUiEvent.ReloadMoviesScreen -> {
                // ignored
            }

            MainUiEvent.ReloadPeoplesScreen -> {
                // ignored
            }
        }
    }
    MainScreenUi(onEvent = onEvent)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreenUi(
    onEvent: (MainUiEvent) -> Unit
) {
    val pagerState = rememberPagerState()
    val pages = listOf(
        Pages.Movies, Pages.Peoples
    )
    HorizontalPager(pageCount = pages.size, state = pagerState) { index ->
        when (pages[index]) {
            Pages.Movies -> MoviesScreen(onEvent)
            Pages.Peoples -> PeoplesScreen(onEvent)
        }
    }
}
