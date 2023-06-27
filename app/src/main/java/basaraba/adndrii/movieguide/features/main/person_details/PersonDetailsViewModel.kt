package basaraba.adndrii.movieguide.features.main.person_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.person_details.model.PersonDetailsState
import basaraba.adndrii.movieguide.use_case.persons.GetPersonDetailsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: GetPersonDetailsUseCase,
    private val mapper: PersonUiMapper
) : BaseViewModel<PersonDetailsUiEvent, PersonDetailsState>() {

    private var personDetailsJob: Job? = null

    private val personDetails = MutableStateFlow(PersonDetailsState())

    override val viewState: StateFlow<PersonDetailsState> = personDetails.map {
        PersonDetailsState(
            isLoading = it.isLoading,
            personName = checkNotNull(savedStateHandle[PERSON_NAME]).toString(),
            data = it.data
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, PersonDetailsState())

    override fun handleEvent(event: PersonDetailsUiEvent) {
        //ignored
    }

    init {
        getPersonDetails()
    }

    private fun getPersonDetails() {
        personDetailsJob?.cancel()
        personDetailsJob = viewModelScope.launch {
            personDetails.update { it.copy(isLoading = true) }
            val personId = checkNotNull(savedStateHandle[PERSON_ID]).toString()
            useCase.invoke(personId = personId.toLong()).onSuccess { result ->
                personDetails.update {
                    it.copy(
                        isLoading = false,
                        data = mapper.mapPersonDetails(result)
                    )
                }
            }
        }
    }

    companion object {
        private const val PERSON_ID = "personId"
        private const val PERSON_NAME = "personName"
    }
}
