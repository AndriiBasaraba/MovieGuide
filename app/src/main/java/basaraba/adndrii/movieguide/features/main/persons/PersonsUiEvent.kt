package basaraba.adndrii.movieguide.features.main.persons


sealed interface PersonsUiEvent {
    object ReloadPersonsScreen : PersonsUiEvent
    data class ShowPersonDetails(val id: Int) : PersonsUiEvent
}
