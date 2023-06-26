package basaraba.adndrii.movieguide.features.main.person_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.model.PersonDetailsUiData
import basaraba.adndrii.movieguide.use_case.persons.GetPersonDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PersonDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: GetPersonDetailsUseCase,
    private val mapper: PersonUiMapper
) : ViewModel() {

    private val _personName =
        MutableStateFlow(checkNotNull(savedStateHandle[PERSON_NAME]).toString())
    val personName: StateFlow<String>
        get() = _personName.asStateFlow()

    private val _personDetailsState = MutableStateFlow(PersonDetailsState())
    val personDetailsState: StateFlow<PersonDetailsState>
        get() = _personDetailsState.asStateFlow()

    init {
        getPersonDetails()
    }

    private fun getPersonDetails() = with(viewModelScope) {
        launch {
            val personId = checkNotNull(savedStateHandle[PERSON_ID]).toString()
            val response = useCase.invoke(personId = personId.toLong()).getOrNull()
            if (response != null) {
                _personDetailsState.value = PersonDetailsState(
                    state = State.LOADED,
                    data = mapper.mapPersonDetails(response)
                )
            }
        }
    }

    companion object {
        private const val PERSON_ID = "personId"
        private const val PERSON_NAME = "personName"
    }
}
