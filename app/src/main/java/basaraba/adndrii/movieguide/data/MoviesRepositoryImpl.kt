package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteSource,
    private val localDataSource: MoviesLocalSource
) : MoviesRepository {
    override suspend fun getNowPlayingMovies(): MoviesResponse =
        remoteDataSource.getNowPlayingMovies()

    override suspend fun getUpcomingMovies(): MoviesResponse = remoteDataSource.getUpcomingMovies()

    override suspend fun getMovieDetails(movieId: Int): MovieDetailResponse =
        remoteDataSource.getMovieDetails(movieId)
}
