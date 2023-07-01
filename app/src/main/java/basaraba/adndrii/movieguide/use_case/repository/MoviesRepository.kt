package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getMovieDetails(movieId: Int): MovieDetailsDomainData
}
