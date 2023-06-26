package basaraba.adndrii.movieguide.features.navigation

sealed class NavigationRoute(val route: String) {
    object MovieDetails : NavigationRoute(ROUTE_MOVIE_DETAILS) {
        fun getRouteNameWithArguments(movieId: String): String = "movie/details?movieId=$movieId"
    }

    object PersonDetails : NavigationRoute(ROUTE_PERSON_DETAILS) {
        fun getRouteNameWithArguments(personId: String, personName: String): String =
            "person/details?personId=$personId?personName=$personName"
    }

    companion object {
        internal const val ROUTE_MOVIE_DETAILS = "movie/details?movieId={movieId}"
        internal const val ROUTE_PERSON_DETAILS =
            "person/details?personId={personId}?personName={personName}"
    }
}
