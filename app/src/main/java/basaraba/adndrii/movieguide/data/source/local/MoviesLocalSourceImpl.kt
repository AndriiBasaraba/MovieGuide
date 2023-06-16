package basaraba.adndrii.movieguide.data.source.local

import basaraba.adndrii.movieguide.use_case.model.MovieShortData
import basaraba.adndrii.movieguide.data.db.MovieDao
import basaraba.adndrii.movieguide.data.db.MovieEntity
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper

class MoviesLocalSourceImpl(
    private val movieDao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper
) : MoviesLocalSource {
    override suspend fun getAll(): List<MovieShortData> =
        movieEntityMapper.mapFromDb(movieDao.getAll())

    override suspend fun getAllByType(type: MovieEntity.Type): List<MovieShortData> =
        movieEntityMapper.mapFromDb(movieDao.getAllByType(type))

    override suspend fun insertAll(movies: List<MovieShortData>) {
        movieDao.insertAll(movieEntityMapper.mapToDb(movies))
    }

    override suspend fun delete() {
        movieDao.delete()
    }

    override suspend fun deleteByType(type: MovieEntity.Type) {
        movieDao.deleteByType(type)
    }
}
