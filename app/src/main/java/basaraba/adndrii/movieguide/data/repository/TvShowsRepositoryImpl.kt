package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.mapper.ShowResponseMapper
import basaraba.adndrii.movieguide.data.source.local.shows.ShowsLocalSource
import basaraba.adndrii.movieguide.data.source.remote.tv_shows.TvShowsRemoteSource
import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.TvShowDetailsDomainData
import basaraba.adndrii.movieguide.use_case.repository.TvShowsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val tvShowsRemoteDataSource: TvShowsRemoteSource,
    private val showsLocalDataSource: ShowsLocalSource,
    private val showResponseMapper: ShowResponseMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : TvShowsRepository {
    override suspend fun getTvShowDetails(tvShowId: Long): TvShowDetailsDomainData =
        withContext(ioDispatcher) {
            val isTvShowBookmarked = async { showsLocalDataSource.isShowBookmarked(tvShowId) }
            val details = async { tvShowsRemoteDataSource.getTvShowDetails(tvShowId) }
            val images = async { tvShowsRemoteDataSource.getTvShowImages(tvShowId) }
            val credits = async { tvShowsRemoteDataSource.getTvShowCredits(tvShowId) }
            val recommendations =
                async { tvShowsRemoteDataSource.getTvShowRecommendations(tvShowId).results }
            val keywords = async { tvShowsRemoteDataSource.getTvShowKeywords(tvShowId) }
            val externalIds = async { tvShowsRemoteDataSource.getTvShowExternalIds(tvShowId) }

            return@withContext showResponseMapper.mapDetails(
                details.await(),
                images.await(),
                credits.await(),
                recommendations.await(),
                keywords.await(),
                isTvShowBookmarked.await(),
                externalIds.await()
            )
        }
}
