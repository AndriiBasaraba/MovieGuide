package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUpcomingMoviesUseCase(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(forceReload: Boolean = false): Result<List<MovieDomainData>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getUpcomingMovies(forceReload)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
