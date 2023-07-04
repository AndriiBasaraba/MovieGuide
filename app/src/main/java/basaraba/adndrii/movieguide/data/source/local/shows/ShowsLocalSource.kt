package basaraba.adndrii.movieguide.data.source.local.shows

import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import kotlinx.coroutines.flow.Flow

interface ShowsLocalSource {
    fun getAll(): Flow<List<ShowDomainData>>
    suspend fun insert(show: ShowDomainData)
    suspend fun deleteAll()
    suspend fun deleteShow(showId: Long)
    suspend fun isShowBookmarked(showId: Long): Boolean
}
