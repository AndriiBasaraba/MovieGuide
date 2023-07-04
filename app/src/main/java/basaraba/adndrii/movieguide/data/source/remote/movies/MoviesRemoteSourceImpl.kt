package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(
    private val api: MovieApi
) : MoviesRemoteSource {
    override suspend fun getNowPlayingMovies(): CollectionBaseResponse<ShowResponse> =
        api.getNowPlayingMovies()

    override suspend fun getUpcomingMovies(): CollectionBaseResponse<ShowResponse> =
        api.getUpcomingMovies()

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsResponse =
        api.getMovieDetails(movieId)

    override suspend fun getMovieImages(movieId: Long): ShowImageResponse =
        api.getMovieImages(movieId)

    override suspend fun getMovieCredits(movieId: Long): ShowCastResponse =
        api.getMovieCredits(movieId)

    override suspend fun getMovieRecommendations(movieId: Long): CollectionBaseResponse<ShowResponse> =
        api.getMovieRecommendations(movieId)

    override suspend fun getMovieKeywords(movieId: Long): ShowKeywordsResponse =
        api.getMovieKeywords(movieId)
}
