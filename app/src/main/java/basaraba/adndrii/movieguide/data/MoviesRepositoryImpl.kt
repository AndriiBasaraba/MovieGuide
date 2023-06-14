package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteSource,
    private val localDataSource: MoviesLocalSource
) : MoviesRepository {
    override suspend fun nowPlayingMovies(): MoviesResponse = remoteDataSource.nowPlayingMovies()

    override suspend fun upcomingMovies(): MoviesResponse = remoteDataSource.upcomingMovies()

    override suspend fun movieDetails(movieId: Int): MovieDetailResponse =
        remoteDataSource.movieDetails(movieId)
}
