package basaraba.adndrii.movieguide.features.main.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.GetUpcomingMoviesUseCase
import kotlinx.coroutines.async

class MoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {

    fun loadMovies() = with(viewModelScope) {

       val now = async {
            val response = getNowPlayingMoviesUseCase.invoke()
            println("movie response = $response")
        }

       val upComing = async {
            val response = getUpcomingMoviesUseCase.invoke()
            println("movie response = $response")
        }

    }
}
