package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.mapper.ShowResponseMapper
import basaraba.adndrii.movieguide.data.source.local.shows.ShowsLocalSource
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSource
import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteSource,
    private val showsLocalDataSource: ShowsLocalSource,
    private val showResponseMapper: ShowResponseMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MoviesRepository {
    override suspend fun getNowPlayingMovies(forceReload: Boolean): List<ShowDomainData> {
        return emptyList()
    }

    override suspend fun getUpcomingMovies(forceReload: Boolean): List<ShowDomainData> {
        return emptyList()
    }

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsDomainData =
        withContext(ioDispatcher) {
            val isMovieBookmarked = async { showsLocalDataSource.isShowBookmarked(movieId) }
            val details = async { moviesRemoteDataSource.getMovieDetails(movieId) }
            val images = async { moviesRemoteDataSource.getMovieImages(movieId) }
            val credits = async { moviesRemoteDataSource.getMovieCredits(movieId) }
            val recommendations =
                async { moviesRemoteDataSource.getMovieRecommendations(movieId).results }
            val keywords = async { moviesRemoteDataSource.getMovieKeywords(movieId) }

            return@withContext showResponseMapper.mapDetails(
                details.await(),
                images.await(),
                credits.await(),
                recommendations.await(),
                keywords.await(),
                isMovieBookmarked.await()
            )
        }
}
