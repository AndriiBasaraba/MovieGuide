package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRemoteSource {
    suspend fun getNowPlayingMovies(): MoviesResponse
    suspend fun getUpcomingMovies(): MoviesResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
