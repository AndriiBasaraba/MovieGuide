package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.source.local.movies.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSource
import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteSource,
    private val moviesLocalDataSource: MoviesLocalSource,
    private val moviesResponseMapper: MoviesResponseMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MoviesRepository {
    override suspend fun getNowPlayingMovies(forceReload: Boolean): List<MovieDomainData> {
        return moviesResponseMapper.map(
            moviesRemoteDataSource.getNowPlayingMovies().results
        )
    }

    override suspend fun getUpcomingMovies(forceReload: Boolean): List<MovieDomainData> {
        return moviesResponseMapper.map(
            moviesRemoteDataSource.getUpcomingMovies().results
        )
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDomainData =
        withContext(ioDispatcher) {
            val details = async { moviesRemoteDataSource.getMovieDetails(movieId) }
            val images = async { moviesRemoteDataSource.getMovieImages(movieId) }
            val credits = async { moviesRemoteDataSource.getMovieCredits(movieId) }
//            val recommendations =
//                async { moviesRemoteDataSource.getMovieRecommendations(movieId).results }
            val keywords = async { moviesRemoteDataSource.getMovieKeywords(movieId) }


            return@withContext moviesResponseMapper.mapDetails(
                details.await(),
                images.await(),
                credits.await(),
                emptyList(),
                keywords.await()
            )
        }
}
