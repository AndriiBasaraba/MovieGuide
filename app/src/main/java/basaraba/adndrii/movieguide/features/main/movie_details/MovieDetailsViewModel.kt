package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    val movieId: String = checkNotNull(savedStateHandle[MOVIE_ID])

    init {
        getMovieDetail()
    }

    private fun getMovieDetail() = with(viewModelScope) {
        launch {
            val response = getMovieDetailUseCase.invoke(movieId.toInt())
            println("movie response = $response")
        }
    }

    companion object {
        private const val MOVIE_ID = "movieId"
    }
}
