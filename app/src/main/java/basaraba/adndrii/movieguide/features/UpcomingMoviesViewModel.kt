package basaraba.adndrii.movieguide.features

import androidx.lifecycle.ViewModel
import basaraba.adndrii.movieguide.use_case.UpcomingMoviesUseCase

class UpcomingMoviesViewModel(
   private val useCase: UpcomingMoviesUseCase
) : ViewModel() {
}
