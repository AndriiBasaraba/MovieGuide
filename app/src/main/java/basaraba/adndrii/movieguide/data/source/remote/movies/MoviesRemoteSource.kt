package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse

interface MoviesRemoteSource {
    suspend fun getNowPlayingMovies(): CollectionBaseResponse<ShowResponse>
    suspend fun getUpcomingMovies(): CollectionBaseResponse<ShowResponse>
    suspend fun getMovieDetails(movieId: Long): MovieDetailsResponse
    suspend fun getMovieImages(movieId: Long): ShowImageResponse
    suspend fun getMovieCredits(movieId: Long): ShowCastResponse
    suspend fun getMovieRecommendations(movieId: Long): CollectionBaseResponse<ShowResponse>
    suspend fun getMovieKeywords(movieId: Long): ShowKeywordsResponse
}
