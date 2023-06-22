package basaraba.adndrii.movieguide.features.main.person_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PersonDetailsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val personId: String = checkNotNull(savedStateHandle[PERSON_ID])

    companion object {
        private const val PERSON_ID = "personId"
    }
}
