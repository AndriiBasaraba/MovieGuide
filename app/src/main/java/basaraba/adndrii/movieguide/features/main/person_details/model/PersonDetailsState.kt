package basaraba.adndrii.movieguide.features.main.person_details.model

import basaraba.adndrii.movieguide.common.ViewState

data class PersonDetailsState(
    val isLoading: Boolean = false,
    val personName: String = "",
    val data: PersonDetailsUiData = PersonDetailsUiData.initial
) : ViewState
