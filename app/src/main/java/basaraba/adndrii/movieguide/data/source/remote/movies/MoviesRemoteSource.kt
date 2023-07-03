package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.MovieImageResponse
import basaraba.adndrii.movieguide.data.api.model.MovieKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRemoteSource {
    suspend fun getNowPlayingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getUpcomingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getMovieDetails(movieId: Long): MovieDetailsResponse
    suspend fun getMovieImages(movieId: Long): MovieImageResponse
    suspend fun getMovieCredits(movieId: Long): MovieCastResponse
    suspend fun getMovieRecommendations(movieId: Long): CollectionBaseResponse<MoviesResponse>
    suspend fun getMovieKeywords(movieId: Long): MovieKeywordsResponse
}
