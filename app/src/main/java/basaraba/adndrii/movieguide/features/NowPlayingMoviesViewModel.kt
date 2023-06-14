package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase

class NowPlayingMoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {
}
