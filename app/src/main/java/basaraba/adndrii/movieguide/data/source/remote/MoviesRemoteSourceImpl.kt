package basaraba.adndrii.movieguide.data.source.remote

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

class MoviesRemoteSourceImpl(
    private val api: MovieApi
) : MoviesRemoteSource {
    override suspend fun nowPlayingMovies(): MoviesResponse = api.nowPlayingMovies()

    override suspend fun upcomingMovies(): MoviesResponse = api.upcomingMovies()

    override suspend fun movieDetails(movieId: Int): MovieDetailResponse = api.movieDetails(movieId)
}
