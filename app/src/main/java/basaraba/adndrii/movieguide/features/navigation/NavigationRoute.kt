package basaraba.adndrii.movieguide.features.navigation

abstract class NavigationRoute(val route: String) {
    object Main : NavigationRoute(ROUTE_MAIN)
    object Close : NavigationRoute(ROUTE_CLOSE)
    object MovieDetails : NavigationRoute(ROUTE_MOVIE_DETAILS) {
        const val ARG_MOVIE_ID = "movieId"
        fun getRouteNameWithArguments(movieId: String): String = "movie/details?movieId=$movieId"

    }
    object PeopleDetails : NavigationRoute(ROUTE_PEOPLE_DETAILS) {
        const val ARG_PEOPLE_ID = "peopleId"
        fun getRouteNameWithArguments(peopleId: String): String =
            "people/details?peopleId=$peopleId"
    }

    companion object {

        internal const val ROUTE_MOVIE_DETAILS = "movie/details?movieId={movieId}"
        internal const val ROUTE_PEOPLE_DETAILS = "people/details?peopleId={peopleId}"
        internal const val ROUTE_CLOSE = "close"
        internal const val ROUTE_MAIN = "main"
    }
}
