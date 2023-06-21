package basaraba.adndrii.movieguide.features.main


sealed interface MainUiEvent {
    object NavigateBack : MainUiEvent
    object ReloadMoviesScreen : MainUiEvent
    object ReloadPeoplesScreen : MainUiEvent
    data class ShowMovieDetail(val id: Int) : MainUiEvent
    data class ShowPeopleDetail(val id: Int) : MainUiEvent
}
