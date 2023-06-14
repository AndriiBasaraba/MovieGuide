package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.db.MovieEntity
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteSource,
    private val localDataSource: MoviesLocalSource,
    private val moviesResponseMapper: MoviesResponseMapper
) : MoviesRepository {
    override suspend fun getNowPlayingMovies(): List<MovieShortData> {
        val moviesFromDb = localDataSource.getAllByType(MovieEntity.Type.Ongoing)

        if (moviesFromDb.isEmpty()) {
            val moviesFromRemote = moviesResponseMapper.map(
                remoteDataSource.getNowPlayingMovies(),
                MovieShortData.Type.Ongoing
            )
            localDataSource.insertAll(moviesFromRemote)
            return moviesFromRemote
        }

        return moviesFromDb
    }

    override suspend fun getUpcomingMovies(): List<MovieShortData> {
        val moviesFromDb = localDataSource.getAllByType(MovieEntity.Type.Upcoming)

        if (moviesFromDb.isEmpty()) {
            val moviesFromRemote = moviesResponseMapper.map(
                remoteDataSource.getUpcomingMovies(),
                MovieShortData.Type.Upcoming
            )
            localDataSource.insertAll(moviesFromRemote)
            return moviesFromRemote
        }

        return moviesFromDb
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailResponse =
        remoteDataSource.getMovieDetails(movieId)
}
