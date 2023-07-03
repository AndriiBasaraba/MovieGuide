package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.data.db.dao.MovieDao
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesLocalSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper
) : MoviesLocalSource {
    override fun getAll(): Flow<List<MovieDomainData>> =
        movieDao.getAllMovies().map { movieEntityMapper.mapFromDb(it) }


    override suspend fun insert(movie: MovieDomainData) {
        movieDao.insertMovie(movieEntityMapper.mapToDb(movie))
    }

    override suspend fun insertAll(movies: List<MovieDomainData>) {
        movieDao.insertAllMovies(movieEntityMapper.mapToDb(movies))
    }

    override suspend fun deleteAll() {
        movieDao.deleteMovies()
    }

    override suspend fun deleteMovie(movieId: Long) {
        movieDao.deleteMovie(movieId)
    }

    override suspend fun isMovieBookmarked(movieId: Long): Boolean =
        movieDao.isMovieBookmarked(movieId)
}
