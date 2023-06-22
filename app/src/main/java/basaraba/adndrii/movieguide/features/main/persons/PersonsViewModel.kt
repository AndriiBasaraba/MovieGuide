package basaraba.adndrii.movieguide.features.main.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
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

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    fun refreshScreen() {
        loadPersons(forceReload = true)
    }

    private fun loadPersons(forceReload: Boolean = false) = with(viewModelScope) {
        launch {
            _isRefreshing.value = true
            val mappedData =
                personUiMapper.map(
                    getPopularPersonsUseCase.invoke(forceReload).getOrNull().orEmpty()
                )
            _uiState.value = mappedData
            _isRefreshing.value = false
        }
    }

    init {
        loadPersons()
    }
}
