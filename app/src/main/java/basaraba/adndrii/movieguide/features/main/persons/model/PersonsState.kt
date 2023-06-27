package basaraba.adndrii.movieguide.features.main.persons.model

import basaraba.adndrii.movieguide.common.ViewState
import basaraba.adndrii.movieguide.features.main.persons.PersonsView

data class PersonsState(
    val isRefreshing: Boolean = true,
    val screenView: PersonsView = PersonsView.GRID,
    val data: List<PersonUiData> = emptyList()
) : ViewState
