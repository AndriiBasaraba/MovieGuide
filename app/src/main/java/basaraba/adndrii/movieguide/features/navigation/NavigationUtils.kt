package basaraba.adndrii.movieguide.features.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun NavOptionsBuilder.setDefaultBackNavigation(navController: NavController) {
    navController.graph.startDestinationRoute?.let { route ->
        popUpTo(route) {
            saveState = true
        }
    }
}
