package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.data.db.dao.MovieDao
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import javax.inject.Inject

class MoviesLocalSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper
) : MoviesLocalSource {
    override suspend fun getAll(): List<MovieDomainData> =
        movieEntityMapper.mapFromDb(movieDao.getAllMovies())

    override suspend fun insertAll(movies: List<MovieDomainData>) {
        movieDao.insertAllMovies(movieEntityMapper.mapToDb(movies))
    }

    override suspend fun delete() {
        movieDao.deleteMovies()
    }

    override suspend fun isMovieBookmarked(movieId: Int): Boolean  =
        movieDao.isMovieBookmarked(movieId)
}
