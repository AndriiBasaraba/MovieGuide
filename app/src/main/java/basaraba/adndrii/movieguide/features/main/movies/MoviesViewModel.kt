package basaraba.adndrii.movieguide.features.main.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.movies.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetUpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            loadMovies()
        }
    }

    private suspend fun loadMovies() = with(viewModelScope) {

        val now = async { getNowPlayingMoviesUseCase.invoke() }
        val upComing = async { getUpcomingMoviesUseCase.invoke() }

        println("movies response now = ${now.await()}")
        println("movies response upComing = ${upComing.await()}")
    }
}
