package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.MovieDetailUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val useCase: MovieDetailUseCase
) : ViewModel() {

    fun getMovieDetail() = with(viewModelScope) {
        launch {
            val response = useCase.getMovieDetail(552688)
            println("movie response = $response")
        }
    }
}
