package basaraba.adndrii.movieguide.features.main.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.features.getCurrentPage
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.model.ViewType
import basaraba.adndrii.movieguide.use_case.persons.GetPopularPersonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PersonsViewModel(
    private val getPopularPersonsUseCase: GetPopularPersonsUseCase,
    private val personUiMapper: PersonUiMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<PersonUiData>>(emptyList())
    val uiState: StateFlow<List<PersonUiData>>
        get() = _uiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(true)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _screenView = MutableStateFlow(PersonsView.GRID)
    val screenView: StateFlow<PersonsView>
        get() = _screenView.asStateFlow()

    fun changeScreenView() {
        _screenView.value = if (_screenView.value == PersonsView.GRID) {
            PersonsView.LIST
        } else {
            PersonsView.GRID
        }
    }

    fun loadNextPage() {
        val nextPage = _uiState.value.getCurrentPage() + DEFAULT_PAGE
        _uiState.value = _uiState.value.filter { it.viewType == ViewType.PERSON } +
                PersonUiData.LoadingMore(isLoading = true)
        loadPersons(nextPage)
    }

    fun refreshScreen() {
        loadPersons(DEFAULT_PAGE)
    }

    private fun loadPersons(page: Int) = with(viewModelScope) {
        launch {
            val mappedData =
                personUiMapper.map(
                    getPopularPersonsUseCase.invoke(page).getOrNull().orEmpty()
                )
            val updatedList = if (page == DEFAULT_PAGE) {
                mappedData
            } else {
                _uiState.value.filter { it.viewType == ViewType.PERSON } + mappedData
            }
            _uiState.value = updatedList
            _isRefreshing.value = false
        }
    }

    init {
        loadPersons(DEFAULT_PAGE)
    }

    companion object {
        private const val DEFAULT_PAGE = 1
    }
}
