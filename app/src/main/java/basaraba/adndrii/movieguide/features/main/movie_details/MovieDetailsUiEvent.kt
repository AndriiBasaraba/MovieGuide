package basaraba.adndrii.movieguide.features.main.movie_details

import basaraba.adndrii.movieguide.common.ViewEvent

abstract class MovieDetailsUiEvent : ViewEvent {
    object Back : MovieDetailsUiEvent()
    data class OpenMovieDetails(val id: Long, val title: String) : MovieDetailsUiEvent()
    data class ShowImagePreview(val url: String) : MovieDetailsUiEvent()
    data class ShowPersonDetails(val id: Long, val name: String) : MovieDetailsUiEvent()
    data class UpdateBookmark(val isBookmarked: Boolean) : MovieDetailsUiEvent()
}
