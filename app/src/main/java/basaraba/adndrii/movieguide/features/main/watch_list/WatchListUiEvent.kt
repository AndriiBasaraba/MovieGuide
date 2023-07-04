package basaraba.adndrii.movieguide.features.main.watch_list

import basaraba.adndrii.movieguide.common.ViewEvent


abstract class WatchListUiEvent : ViewEvent {
    data class OpenMovieDetails(val id: Long, val title: String) : WatchListUiEvent()
    data class OpenTvShowDetails(val id: Long, val title: String) : WatchListUiEvent()
    data class DeleteBookmark(val id: Long) : WatchListUiEvent()
    data class OnQueryChange(val text: String) : WatchListUiEvent()
}
