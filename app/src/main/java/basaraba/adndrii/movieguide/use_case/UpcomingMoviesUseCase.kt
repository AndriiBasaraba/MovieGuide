package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.data.api.model.Movie
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UpcomingMoviesUseCase {
    suspend fun getUpcomingMovies(): Result<List<Movie>>
}

class UpcomingMoviesUseCaseImpl(
    private val remoteSource: MoviesRemoteSource
) : UpcomingMoviesUseCase {

    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = remoteSource.upcomingMovies().results
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
