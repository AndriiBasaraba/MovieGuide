package basaraba.adndrii.movieguide.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import basaraba.adndrii.movieguide.features.main.movie_details.MovieDetailsScreen
import basaraba.adndrii.movieguide.features.main.movies.MoviesScreen
import basaraba.adndrii.movieguide.features.main.person_details.PersonDetailsScreen
import basaraba.adndrii.movieguide.features.main.persons.PersonsScreen
import basaraba.adndrii.movieguide.features.main.tv_show_details.TvShowDetailsScreen
import basaraba.adndrii.movieguide.features.main.tv_shows.TvShowsScreen
import basaraba.adndrii.movieguide.features.main.watch_list.WatchListScreen
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.MovieDetails
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.PersonDetails
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.TvShowDetails
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute.ImagePreview
import basaraba.adndrii.movieguide.features.main.image_preview.ImagePreviewScreen

fun NavGraphBuilder.appNavigationGraph(
    navController: NavController
) {
    composable(BottomNavItem.Movies.route) {
        MoviesScreen(navController)
    }

    composable(BottomNavItem.WatchList.route) {
        WatchListScreen(navController)
    }

    composable(BottomNavItem.TvShows.route) {
        TvShowsScreen(navController)
    }

    composable(BottomNavItem.Persons.route) {
        PersonsScreen(navController)
    }

    composable(MovieDetails.route) {
        MovieDetailsScreen(navController)
    }

    composable(TvShowDetails.route) {
        TvShowDetailsScreen(navController)
    }

    composable(PersonDetails.route) {
        PersonDetailsScreen(navController)
    }

    composable(ImagePreview.route) {
        ImagePreviewScreen()
    }
}
