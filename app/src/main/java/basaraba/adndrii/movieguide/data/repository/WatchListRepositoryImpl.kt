package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.source.local.movies.ShowLocalSource
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.repository.WatchListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchListRepositoryImpl @Inject constructor(
    private val showsLocalDataSource: ShowLocalSource
) : WatchListRepository {

    override suspend fun getBookmarkedShows(): Flow<List<ShowDomainData>> =
        showsLocalDataSource.getAll()

    override suspend fun deleteShowBookmark(showId: Long) {
        showsLocalDataSource.deleteShow(showId)
    }

    override suspend fun saveShowBookmark(show: ShowDomainData) {
        showsLocalDataSource.insert(show)
    }
}
