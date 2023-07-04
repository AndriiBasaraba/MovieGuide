package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.repository.WatchListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBookmarkedMoviesUseCase @Inject constructor(
    private val repository: WatchListRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<Flow<List<ShowDomainData>>> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getBookmarkedShows()
            }
        }
}
