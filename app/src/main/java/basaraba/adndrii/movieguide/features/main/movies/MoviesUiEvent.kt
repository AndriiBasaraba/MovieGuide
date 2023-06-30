package basaraba.adndrii.movieguide.features.main.movies

import basaraba.adndrii.movieguide.common.ViewEvent


abstract class MoviesUiEvent : ViewEvent {
    object ReloadMoviesScreen : MoviesUiEvent()
    data class ShowMovieDetails(val id: Long, val title: String) : MoviesUiEvent()
}
