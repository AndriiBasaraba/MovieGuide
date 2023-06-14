package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRepository {
    suspend fun getNowPlayingMovies(): List<MovieShortData>
    suspend fun getUpcomingMovies(): List<MovieShortData>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
