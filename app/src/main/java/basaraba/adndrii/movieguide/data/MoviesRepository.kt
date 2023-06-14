package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRepository {
    suspend fun getNowPlayingMovies(): MoviesResponse
    suspend fun getUpcomingMovies(): MoviesResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
