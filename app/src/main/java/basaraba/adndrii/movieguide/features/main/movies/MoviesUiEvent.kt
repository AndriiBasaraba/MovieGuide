package basaraba.adndrii.movieguide.features.main.movies


sealed interface MoviesUiEvent {
    object ReloadMoviesScreen : MoviesUiEvent
    data class ShowMovieDetails(val id: Int) : MoviesUiEvent
}
