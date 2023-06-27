package basaraba.adndrii.movieguide.features.main.person_details

import basaraba.adndrii.movieguide.common.ViewEvent

abstract class PersonDetailsUiEvent : ViewEvent {
    object Back : PersonDetailsUiEvent()
    data class ShowMovieDetails(val id: Long) : PersonDetailsUiEvent()
    data class ShowTvShowDetails(val id: Long) : PersonDetailsUiEvent()
}
