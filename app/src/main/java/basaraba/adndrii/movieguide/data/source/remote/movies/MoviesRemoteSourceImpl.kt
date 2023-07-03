package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.MovieImageResponse
import basaraba.adndrii.movieguide.data.api.model.MovieKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(
    private val api: MovieApi
) : MoviesRemoteSource {
    override suspend fun getNowPlayingMovies(): CollectionBaseResponse<MoviesResponse> =
        api.getNowPlayingMovies()

    override suspend fun getUpcomingMovies(): CollectionBaseResponse<MoviesResponse> =
        api.getUpcomingMovies()

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsResponse =
        api.getMovieDetails(movieId)

    override suspend fun getMovieImages(movieId: Long): MovieImageResponse =
        api.getMovieImages(movieId)

    override suspend fun getMovieCredits(movieId: Long): MovieCastResponse =
        api.getMovieCredits(movieId)

    override suspend fun getMovieRecommendations(movieId: Long): CollectionBaseResponse<MoviesResponse> =
        api.getMovieRecommendations(movieId)

    override suspend fun getMovieKeywords(movieId: Long): MovieKeywordsResponse =
        api.getMovieKeywords(movieId)
}
