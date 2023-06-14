package basaraba.adndrii.movieguide.data

import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRepository {
    suspend fun nowPlayingMovies(): MoviesResponse
    suspend fun upcomingMovies(): MoviesResponse
    suspend fun movieDetails(movieId: Int): MovieDetailResponse
}
