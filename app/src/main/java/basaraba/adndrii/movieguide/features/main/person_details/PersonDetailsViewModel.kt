package basaraba.adndrii.movieguide.features.main.person_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.use_case.persons.GetPersonDetailsUseCase
import kotlinx.coroutines.launch

class PersonDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val useCase: GetPersonDetailsUseCase,
    private val mapper: PersonUiMapper
) : ViewModel() {

    val personId: String = checkNotNull(savedStateHandle[PERSON_ID])


    init {
        getPersonDetails()
    }

    private fun getPersonDetails() = with(viewModelScope) {
        launch {
            val response = useCase.invoke(personId = personId.toLong()).getOrNull()
            if (response != null) {
                val mapped = mapper.mapPersonDetails(response)
                println("person detail = $mapped")
            }
        }
    }

    companion object {
        private const val PERSON_ID = "personId"
    }
}
