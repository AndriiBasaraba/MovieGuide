package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import kotlinx.coroutines.flow.Flow

interface MoviesLocalSource {
    fun getAll(): Flow<List<MovieDomainData>>
    suspend fun insertAll(movies: List<MovieDomainData>)
    suspend fun insert(movie: MovieDomainData)
    suspend fun deleteAll()
    suspend fun deleteMovie(movieId: Int)
    suspend fun isMovieBookmarked(movieId: Int): Boolean
}
