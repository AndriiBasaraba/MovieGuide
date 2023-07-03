package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBookmarkedMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<Flow<List<MovieDomainData>>> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getBookmarkedMovies()
            }
        }
}
