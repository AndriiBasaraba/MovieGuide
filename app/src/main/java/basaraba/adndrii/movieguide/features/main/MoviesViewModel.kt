package basaraba.adndrii.movieguide.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.GetUpcomingMoviesUseCase
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {

    fun getNowPlayingMoviesUseCase() = with(viewModelScope) {
        launch {
            val response = getNowPlayingMoviesUseCase.invoke()
            println("movie response = $response")
        }
    }

    fun getUpComingMoviesUseCase() = with(viewModelScope) {
        launch {
            val response = getUpcomingMoviesUseCase.invoke()
            println("movie response = $response")
        }
    }
}
