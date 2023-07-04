package basaraba.adndrii.movieguide.features.main.tv_show_details

import basaraba.adndrii.movieguide.common.ViewEvent

abstract class TvShowDetailsUiEvent : ViewEvent {
    object Back : TvShowDetailsUiEvent()
    data class OpenTvShowDetails(val id: Long, val title: String) : TvShowDetailsUiEvent()
    data class ShowImagePreview(val url: String) : TvShowDetailsUiEvent()
    data class ShowPersonDetails(val id: Long, val name: String) : TvShowDetailsUiEvent()
    data class UpdateBookmark(val isBookmarked: Boolean) : TvShowDetailsUiEvent()
}
