package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.data.db.MovieEntity
import basaraba.adndrii.movieguide.data.db.MovieGuideDao
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData

class MoviesLocalSourceImpl(
    private val movieGuideDao: MovieGuideDao,
    private val movieEntityMapper: MovieEntityMapper
) : MoviesLocalSource {
    override suspend fun getAll(): List<MovieDomainData> =
        movieEntityMapper.mapFromDb(movieGuideDao.getAllMovies())

    override suspend fun getAllByType(type: MovieEntity.Type): List<MovieDomainData> =
        movieEntityMapper.mapFromDb(movieGuideDao.getAllMoviesByType(type))

    override suspend fun insertAll(movies: List<MovieDomainData>) {
        movieGuideDao.insertAllMovies(movieEntityMapper.mapToDb(movies))
    }

    override suspend fun delete() {
        movieGuideDao.deleteMovies()
    }

    override suspend fun deleteByType(type: MovieEntity.Type) {
        movieGuideDao.deleteMoviesByType(type)
    }
}
