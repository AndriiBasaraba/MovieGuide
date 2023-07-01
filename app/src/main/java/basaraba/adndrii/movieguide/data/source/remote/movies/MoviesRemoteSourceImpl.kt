package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
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

    override suspend fun getMovieDetails(movieId: Int): MovieDetailResponse =
        api.getMovieDetails(movieId)

    override suspend fun getMovieImages(movieId: Int): MovieImageResponse =
        api.getMovieImages(movieId)

    override suspend fun getMovieCredits(movieId: Int): MovieCastResponse =
        api.getMovieCredits(movieId)

    override suspend fun getMovieRecommendations(movieId: Int): CollectionBaseResponse<MoviesResponse> =
        api.getMovieRecommendations(movieId)

    override suspend fun getMovieKeywords(movieId: Int): MovieKeywordsResponse =
        api.getMovieKeywords(movieId)
}
