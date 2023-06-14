package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieDetailUseCase {
    suspend fun getMovieDetail(movieId: Int): Result<MovieDetailResponse>
}

class MovieDetailUseCaseImpl(
    private val remoteSource: MoviesRemoteSource
) : MovieDetailUseCase {
    override suspend fun getMovieDetail(movieId: Int): Result<MovieDetailResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = remoteSource.movieDetails(movieId = movieId)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
