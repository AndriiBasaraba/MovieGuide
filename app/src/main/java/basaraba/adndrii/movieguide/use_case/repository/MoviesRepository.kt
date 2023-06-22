package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
