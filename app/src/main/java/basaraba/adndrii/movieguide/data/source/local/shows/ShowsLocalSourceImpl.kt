package basaraba.adndrii.movieguide.data.source.local.shows

import basaraba.adndrii.movieguide.data.db.dao.ShowDao
import basaraba.adndrii.movieguide.data.db.mapper.ShowEntityMapper
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShowsLocalSourceImpl @Inject constructor(
    private val showDao: ShowDao,
    private val showEntityMapper: ShowEntityMapper
) : ShowsLocalSource {
    override fun getAll(): Flow<List<ShowDomainData>> =
        showDao.getAllShows().map { showEntityMapper.mapFromDb(it) }


    override suspend fun insert(show: ShowDomainData) {
        showDao.insertShow(showEntityMapper.mapToDb(show))
    }

    override suspend fun deleteAll() {
        showDao.deleteShows()
    }

    override suspend fun deleteShow(showId: Long) {
        showDao.deleteShow(showId)
    }

    override suspend fun isShowBookmarked(showId: Long): Boolean =
        showDao.isShowBookmarked(showId)
}
