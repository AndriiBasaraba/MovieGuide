package basaraba.adndrii.movieguide.data.source.remote.movies

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

class MoviesRemoteSourceImpl(
    private val api: MovieApi
) : MoviesRemoteSource {
    override suspend fun getNowPlayingMovies(): CollectionBaseResponse<MoviesResponse> =
        api.getNowPlayingMovies()

    override suspend fun getUpcomingMovies(): CollectionBaseResponse<MoviesResponse> =
        api.getUpcomingMovies()

    override suspend fun getMovieDetails(movieId: Int): MovieDetailResponse =
        api.getMovieDetails(movieId)
}
