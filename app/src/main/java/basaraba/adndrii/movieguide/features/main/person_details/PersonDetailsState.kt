package basaraba.adndrii.movieguide.features.main.person_details

import basaraba.adndrii.movieguide.features.main.model.PersonDetailsUiData

data class PersonDetailsState(
    val state: State = State.INITIAL,
    val data: PersonDetailsUiData? = null
)

enum class State {
    INITIAL, LOADED
}
