package basaraba.adndrii.movieguide.features.main.persons

import basaraba.adndrii.movieguide.common.ViewEvent


abstract class PersonsUiEvent : ViewEvent {
    object ReloadPersonsScreen : PersonsUiEvent()
    object LoadMorePersons : PersonsUiEvent()
    object ChangeScreenView : PersonsUiEvent()
    data class ShowPersonDetails(val id: Long, val name: String) : PersonsUiEvent()
}
