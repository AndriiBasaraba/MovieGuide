package basaraba.adndrii.movieguide.features.main.persons

import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.getCurrentPage
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.persons.PersonsView.Companion.getChangedView
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.persons.model.PersonsState
import basaraba.adndrii.movieguide.features.main.persons.model.ViewType
import basaraba.adndrii.movieguide.use_case.persons.GetPopularPersonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val getPopularPersonsUseCase: GetPopularPersonsUseCase,
    private val personUiMapper: PersonUiMapper
) : BaseViewModel<PersonsUiEvent, PersonsState>() {

    private var personsJob: Job? = null

    private val persons = MutableStateFlow(PersonsState())

    override val viewState: StateFlow<PersonsState> = persons.map {
        PersonsState(
            isRefreshing = it.isRefreshing,
            screenView = it.screenView,
            data = it.data
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, PersonsState())

    override fun handleEvent(event: PersonsUiEvent) {
        when (event) {
            PersonsUiEvent.ChangeScreenView -> {
                persons.update {
                    it.copy(
                        screenView = it.screenView.getChangedView()
                    )
                }
            }

            PersonsUiEvent.ReloadPersonsScreen -> {
                persons.update { it.copy(isRefreshing = true) }
                loadPersons(DEFAULT_PAGE)
            }

            PersonsUiEvent.LoadMorePersons -> {
                val nextPage = persons.value.data.getCurrentPage() + DEFAULT_PAGE
                persons.update {
                    it.copy(
                        data = getPersonsWithoutFooter() + PersonUiData.LoadingMore(isLoading = true)
                    )
                }
                loadPersons(nextPage)
            }
        }
    }

    init {
        loadPersons(DEFAULT_PAGE)
    }

    private fun loadPersons(page: Int) {
        personsJob?.cancel()
        personsJob = viewModelScope.launch {
            getPopularPersonsUseCase.invoke(page).onSuccess { result ->
                val mappedData = personUiMapper.map(result)
                val updatedList = if (page == DEFAULT_PAGE) {
                    mappedData
                } else {
                    getPersonsWithoutFooter() + mappedData
                }

                persons.update {
                    it.copy(
                        isRefreshing = false,
                        data = updatedList.toSet().toList()
                    )
                }
            }
        }
    }

    private fun getPersonsWithoutFooter(): List<PersonUiData> =
        persons.value.data.filter { person -> person.viewType == ViewType.PERSON }

    companion object {
        private const val DEFAULT_PAGE = 1
    }
}
