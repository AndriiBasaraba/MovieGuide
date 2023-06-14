package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.data.MoviesRepository
import basaraba.adndrii.movieguide.data.api.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNowPlayingMoviesUseCase(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getNowPlayingMovies().results
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
