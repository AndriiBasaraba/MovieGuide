package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMovieDetailUseCase(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(movieId: Int): Result<MovieDetailResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getMovieDetails(movieId = movieId)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}