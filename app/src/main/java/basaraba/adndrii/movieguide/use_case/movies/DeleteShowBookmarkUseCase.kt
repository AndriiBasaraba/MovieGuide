package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.repository.WatchListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteShowBookmarkUseCase @Inject constructor(
    private val repository: WatchListRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(showId: Long) =
        withContext(ioDispatcher) {
            repository.deleteShowBookmark(showId = showId)
        }
}
