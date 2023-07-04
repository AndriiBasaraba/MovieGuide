package basaraba.adndrii.movieguide.features.main.person_details

import basaraba.adndrii.movieguide.common.ViewEvent

abstract class PersonDetailsUiEvent : ViewEvent {
    object Back : PersonDetailsUiEvent()
    data class OpenMovieDetails(val id: Long, val title: String) : PersonDetailsUiEvent()
    data class OpenTvShowDetails(val id: Long, val title: String) : PersonDetailsUiEvent()
    data class ShowImagePreview(val url: String) : PersonDetailsUiEvent()
}
