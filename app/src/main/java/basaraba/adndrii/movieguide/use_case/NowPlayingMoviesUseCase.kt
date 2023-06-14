package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.data.api.model.Movie
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NowPlayingMoviesUseCase {
    suspend fun getNowPlayingMovies(): Result<List<Movie>>
}

class NowPlayingMoviesUseCaseImpl(
    private val remoteSource: MoviesRemoteSource
) : NowPlayingMoviesUseCase {

    override suspend fun getNowPlayingMovies(): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = remoteSource.nowPlayingMovies().results
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
