package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNowPlayingMoviesUseCase(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(forceReload: Boolean = false): Result<List<MovieDomainData>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getNowPlayingMovies(forceReload)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
