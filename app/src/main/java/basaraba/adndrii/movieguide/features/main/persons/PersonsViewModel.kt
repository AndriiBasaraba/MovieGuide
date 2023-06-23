package basaraba.adndrii.movieguide.features.main.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.features.getCurrentPage
import basaraba.adndrii.movieguide.features.isLoadingMoreEnabled
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.model.LoadingMoreData
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.use_case.persons.GetMorePopularPersonsUseCase
import basaraba.adndrii.movieguide.use_case.persons.GetPopularPersonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PersonsViewModel(
    private val getPopularPersonsUseCase: GetPopularPersonsUseCase,
    private val getMorePopularPersonsUseCase: GetMorePopularPersonsUseCase,
    private val personUiMapper: PersonUiMapper
) : ViewModel() {

    private var page = 1

    private val _uiState = MutableStateFlow<List<PersonUiData>>(emptyList())
    val uiState: StateFlow<List<PersonUiData>>
        get() = _uiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _isLoadingMore = MutableStateFlow(LoadingMoreData())
    val isLoadingMore: StateFlow<LoadingMoreData>
        get() = _isLoadingMore.asStateFlow()

    fun refreshScreen() {
        page = 1
        loadPersons(forceReload = true)
    }

    fun loadNextPage() {
        _isLoadingMore.value = LoadingMoreData(isBtnShown = true, isLoading = true)
        page++
        loadMorePersons()
    }

    private fun loadMorePersons() = with(viewModelScope) {
        launch {
            val mappedData =
                personUiMapper.map(
                    getMorePopularPersonsUseCase.invoke(page).getOrNull().orEmpty()
                )
            _uiState.value = uiState.value + mappedData
            _isLoadingMore.value = LoadingMoreData(isBtnShown = mappedData.isLoadingMoreEnabled())
        }
    }

    private fun loadPersons(forceReload: Boolean = false) = with(viewModelScope) {
        launch {
            _isRefreshing.value = true
            val mappedData =
                personUiMapper.map(
                    getPopularPersonsUseCase.invoke(forceReload).getOrNull().orEmpty()
                )
            _uiState.value = mappedData
            _isLoadingMore.value = LoadingMoreData(isBtnShown = mappedData.isLoadingMoreEnabled())
            _isRefreshing.value = false
            page = mappedData.getCurrentPage()
        }
    }

    init {
        loadPersons()
    }
}
