package basaraba.adndrii.movieguide.features.main.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.persons.GetPopularPersonsUseCase
import kotlinx.coroutines.launch

class PersonsViewModel(
    private val getPopularPersonsUseCase: GetPopularPersonsUseCase
) : ViewModel() {

    init {
        loadPersons()
    }

    private fun loadPersons() = with(viewModelScope) {
        launch {
            val response = getPopularPersonsUseCase.invoke()
            println("persons response = $response")
        }
    }
}
