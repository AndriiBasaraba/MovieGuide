package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRemoteSource {
    suspend fun getNowPlayingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getUpcomingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
}
