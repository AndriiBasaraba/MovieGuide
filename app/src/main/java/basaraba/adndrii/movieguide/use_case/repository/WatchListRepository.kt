package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import kotlinx.coroutines.flow.Flow

interface WatchListRepository {
    suspend fun getBookmarkedShows(): Flow<List<ShowDomainData>>
    suspend fun saveShowBookmark(show: ShowDomainData)
    suspend fun deleteShowBookmark(showId: Long)
}
