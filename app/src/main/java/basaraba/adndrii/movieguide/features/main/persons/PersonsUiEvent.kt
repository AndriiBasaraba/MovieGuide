package basaraba.adndrii.movieguide.features.main.persons


sealed interface PersonsUiEvent {
    object ReloadPersonsScreen : PersonsUiEvent
    object LoadMorePersons : PersonsUiEvent
    object ChangeScreenView : PersonsUiEvent
    data class ShowPersonDetails(val id: Long) : PersonsUiEvent
}
