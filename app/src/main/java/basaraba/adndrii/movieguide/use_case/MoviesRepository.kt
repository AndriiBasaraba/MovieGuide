package basaraba.adndrii.movieguide.use_case

import basaraba.adndrii.movieguide.use_case.model.MovieShortData
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieShortData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieShortData>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
