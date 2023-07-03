package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieDomainData>
    suspend fun getMovieDetails(movieId: Long): MovieDetailsDomainData
    suspend fun getBookmarkedMovies(): Flow<List<MovieDomainData>>
    suspend fun saveMovieBookmark(movie: MovieDomainData)
    suspend fun deleteMovieBookmark(movieId: Long)
}
