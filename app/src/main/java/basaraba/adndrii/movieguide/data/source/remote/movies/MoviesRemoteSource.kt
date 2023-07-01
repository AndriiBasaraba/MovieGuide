package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MovieImageResponse
import basaraba.adndrii.movieguide.data.api.model.MovieKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesRemoteSource {
    suspend fun getNowPlayingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getUpcomingMovies(): CollectionBaseResponse<MoviesResponse>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse
    suspend fun getMovieImages(movieId: Int): MovieImageResponse
    suspend fun getMovieCredits(movieId: Int): MovieCastResponse
    suspend fun getMovieRecommendations(movieId: Int): CollectionBaseResponse<MoviesResponse>
    suspend fun getMovieKeywords(movieId: Int): MovieKeywordsResponse
}
