package basaraba.adndrii.movieguide.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import basaraba.adndrii.movieguide.features.main.movie_details.MovieDetailScreen
import basaraba.adndrii.movieguide.features.main.movies.MoviesScreen
import basaraba.adndrii.movieguide.features.main.person_details.PersonDetailsScreen
import basaraba.adndrii.movieguide.features.main.persons.PersonsScreen
import basaraba.adndrii.movieguide.features.main.watch_list.WatchListScreen
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.MovieDetails
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.PersonDetails

fun NavGraphBuilder.appNavigationGraph(
    navController: NavController
) {
    composable(BottomNavItem.Movies.route) {
        MoviesScreen(navController)
    }

    composable(BottomNavItem.WatchList.route) {
        WatchListScreen(navController)
    }

    composable(BottomNavItem.Persons.route) {
        PersonsScreen(navController)
    }

    composable(MovieDetails.route) {
        MovieDetailScreen()
    }
    composable(PersonDetails.route) {
        PersonDetailsScreen()
    }
}
