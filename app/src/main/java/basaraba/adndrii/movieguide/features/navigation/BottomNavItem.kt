package basaraba.adndrii.movieguide.features.navigation

import androidx.annotation.DrawableRes
import basaraba.adndrii.movieguide.R


sealed class BottomNavItem(val title: String, @DrawableRes val icon: Int, val route: String) {
    object Movies : BottomNavItem("Movies", R.drawable.ic_bottom_bar_movies, ROUTE_MOVIES)
    object Persons : BottomNavItem("Persons", R.drawable.ic_bottom_bar_peoples, ROUTE_PERSONS)

    companion object {
        internal const val ROUTE_MOVIES = "movies"
        internal const val ROUTE_PERSONS = "persons"
    }
}
