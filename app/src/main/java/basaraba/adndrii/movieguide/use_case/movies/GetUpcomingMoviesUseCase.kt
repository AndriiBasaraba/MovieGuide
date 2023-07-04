package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(forceReload: Boolean = false): Result<List<ShowDomainData>> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getUpcomingMovies(forceReload)
            }
        }
}
