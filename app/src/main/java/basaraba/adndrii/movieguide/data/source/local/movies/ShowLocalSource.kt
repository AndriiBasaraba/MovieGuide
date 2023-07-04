package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import kotlinx.coroutines.flow.Flow

interface ShowLocalSource {
    fun getAll(): Flow<List<ShowDomainData>>
    suspend fun insert(show: ShowDomainData)
    suspend fun deleteAll()
    suspend fun deleteShow(showId: Long)
    suspend fun isShowBookmarked(showId: Long): Boolean
}
