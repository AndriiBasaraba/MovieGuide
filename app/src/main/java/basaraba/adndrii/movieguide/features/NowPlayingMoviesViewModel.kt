package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase
import kotlinx.coroutines.launch

class NowPlayingMoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {

    fun getNowPlayingMoviesUseCase() = with(viewModelScope) {
        launch {
            val response = getNowPlayingMoviesUseCase.invoke()
            println("movie response = $response")
        }
    }
}
