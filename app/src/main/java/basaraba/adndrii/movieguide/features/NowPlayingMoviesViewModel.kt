package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import basaraba.adndrii.movieguide.use_case.NowPlayingMoviesUseCase

class NowPlayingMoviesViewModel(
    private val useCase: NowPlayingMoviesUseCase
) : ViewModel() {
}
