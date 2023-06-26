package basaraba.adndrii.movieguide.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import basaraba.adndrii.movieguide.R


sealed class BottomNavItem(@StringRes val title: Int, @DrawableRes val icon: Int, val route: String) {
    object Movies : BottomNavItem(R.string.movies, R.drawable.ic_bottom_bar_movies, ROUTE_MOVIES)
    object WatchList : BottomNavItem(R.string.watch_list, R.drawable.ic_filled_favorite, ROUTE_WATCH_LIST)
    object Persons : BottomNavItem(R.string.persons, R.drawable.ic_bottom_bar_peoples, ROUTE_PERSONS)

    companion object {
        internal const val ROUTE_MOVIES = "movies"
        internal const val ROUTE_WATCH_LIST = "watch_list"
        internal const val ROUTE_PERSONS = "persons"
    }
}
