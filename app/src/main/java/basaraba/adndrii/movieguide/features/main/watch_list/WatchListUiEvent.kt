package basaraba.adndrii.movieguide.features.main.watch_list

import basaraba.adndrii.movieguide.common.ViewEvent


abstract class WatchListUiEvent : ViewEvent {
    data class ShowMovieDetails(val id: Long, val title: String) : WatchListUiEvent()
    data class ShowTvShowDetails(val id: Long, val title: String) : WatchListUiEvent()
    data class DeleteBookmark(val id: Long) : WatchListUiEvent()
}
