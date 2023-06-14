package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.data.MovieShortData
import basaraba.adndrii.movieguide.data.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUpcomingMoviesUseCase(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(): Result<List<MovieShortData>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getUpcomingMovies()
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
