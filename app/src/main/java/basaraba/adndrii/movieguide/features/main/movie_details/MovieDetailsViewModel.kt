package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.movies.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
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
