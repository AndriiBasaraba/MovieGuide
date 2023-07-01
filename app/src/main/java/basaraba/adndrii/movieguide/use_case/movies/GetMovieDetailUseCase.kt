package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MoviesRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(movieId: Int): Result<MovieDetailResponse> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getMovieDetails(movieId = movieId)
            }
        }
}
