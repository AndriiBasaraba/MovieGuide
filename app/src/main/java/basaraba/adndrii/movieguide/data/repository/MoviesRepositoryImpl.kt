package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.db.MovieEntity
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.source.local.movies.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSource
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData

class MoviesRepositoryImpl(
    private val moviesRemoteDataSource: MoviesRemoteSource,
    private val moviesLocalDataSource: MoviesLocalSource,
    private val moviesResponseMapper: MoviesResponseMapper
) : MoviesRepository {
    override suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieDomainData> {
        if (forceReload) {
            moviesLocalDataSource.deleteByType(MovieEntity.Type.Ongoing)
        }

        val moviesFromDb = moviesLocalDataSource.getAllByType(MovieEntity.Type.Ongoing)

        if (moviesFromDb.isEmpty()) {
            val moviesFromRemote = moviesResponseMapper.map(
                moviesRemoteDataSource.getNowPlayingMovies().results,
                MovieDomainData.Type.Ongoing
            )
            moviesLocalDataSource.insertAll(moviesFromRemote)
            return moviesFromRemote
        }

        return moviesFromDb
    }

    override suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieDomainData> {
        if (forceReload) {
            moviesLocalDataSource.deleteByType(MovieEntity.Type.Upcoming)
        }

        val moviesFromDb = moviesLocalDataSource.getAllByType(MovieEntity.Type.Upcoming)

        if (moviesFromDb.isEmpty()) {
            val moviesFromRemote = moviesResponseMapper.map(
                moviesRemoteDataSource.getUpcomingMovies().results,
                MovieDomainData.Type.Upcoming
            )
            moviesLocalDataSource.insertAll(moviesFromRemote)
            return moviesFromRemote
        }

        return moviesFromDb
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailResponse =
        moviesRemoteDataSource.getMovieDetails(movieId)
}
