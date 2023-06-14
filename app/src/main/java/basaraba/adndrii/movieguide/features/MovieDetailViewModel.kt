package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    fun getMovieDetail() = with(viewModelScope) {
        launch {
            val response = getMovieDetailUseCase(552688)
            println("movie response = $response")
        }
    }
}
