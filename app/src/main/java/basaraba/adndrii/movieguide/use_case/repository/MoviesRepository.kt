package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<ShowDomainData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<ShowDomainData>
    suspend fun getMovieDetails(movieId: Long): MovieDetailsDomainData
}
