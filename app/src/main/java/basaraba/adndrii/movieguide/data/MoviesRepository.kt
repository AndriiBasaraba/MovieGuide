package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieShortData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieShortData>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
