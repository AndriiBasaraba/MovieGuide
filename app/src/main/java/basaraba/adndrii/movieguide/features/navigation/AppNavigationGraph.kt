package basaraba.adndrii.movieguide.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import basaraba.adndrii.movieguide.features.main.MainScreen
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.Close
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.Main
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.MovieDetails
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.PeopleDetails

fun NavGraphBuilder.appNavigationGraph(
    navController: NavController,
    onClose: () -> Unit
) {
    composable(Main.route) {
        MainScreen(navController = navController)
    }
    composable(MovieDetails.route) {
        val movieId = checkNotNull(it.arguments?.getString(MovieDetails.ARG_MOVIE_ID)?.toInt())
        // todo add movie details screen
    }
    composable(PeopleDetails.route) {
        val peopleId = checkNotNull(it.arguments?.getString(PeopleDetails.ARG_PEOPLE_ID)?.toInt())
        // todo add people details screen
    }
    composable(Close.route) {
        onClose()
    }
}
