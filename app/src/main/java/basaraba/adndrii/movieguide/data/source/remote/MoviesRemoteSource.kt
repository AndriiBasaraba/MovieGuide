package basaraba.adndrii.movieguide.data.source.remote

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRemoteSource {
    suspend fun nowPlayingMovies(): MoviesResponse
    suspend fun upcomingMovies(): MoviesResponse
    suspend fun movieDetails(movieId: Int): MovieDetailResponse
}
