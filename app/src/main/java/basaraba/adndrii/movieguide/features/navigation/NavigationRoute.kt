package basaraba.adndrii.movieguide.features.navigation

sealed class NavigationRoute(val route: String) {
    object MovieDetails : NavigationRoute(ROUTE_MOVIE_DETAILS) {
        fun getRouteNameWithArguments(movieId: String, movieTitle: String): String =
            "movie/details?movieId=$movieId?movieTitle=$movieTitle"
    }

    object TvShowDetails : NavigationRoute(ROUTE_TV_SHOW_DETAILS) {
        fun getRouteNameWithArguments(tvShowId: String, tvShowTitle: String): String =
            "tv_show/details?tvShowId=$tvShowId?tvShowTitle=$tvShowTitle"
    }

    object PersonDetails : NavigationRoute(ROUTE_PERSON_DETAILS) {
        fun getRouteNameWithArguments(personId: String, personName: String): String =
            "person/details?personId=$personId?personName=$personName"
    }

    object ImagePreview : NavigationRoute(ROUTE_IMAGE_PREVIEW) {
        fun getRouteNameWithArguments(url: String): String = "image_preview?url=$url"
    }

    companion object {
        internal const val ROUTE_MOVIE_DETAILS =
            "movie/details?movieId={movieId}?movieTitle={movieTitle}"
        internal const val ROUTE_TV_SHOW_DETAILS =
            "tv_show/details?tvShowId={tvShowId}?tvShowTitle={tvShowTitle}"
        internal const val ROUTE_PERSON_DETAILS =
            "person/details?personId={personId}?personName={personName}"
        internal const val ROUTE_IMAGE_PREVIEW = "image_preview?url={url}"
    }
}
