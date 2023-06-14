package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import basaraba.adndrii.movieguide.use_case.GetUpcomingMoviesUseCase

class UpcomingMoviesViewModel(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {
}
