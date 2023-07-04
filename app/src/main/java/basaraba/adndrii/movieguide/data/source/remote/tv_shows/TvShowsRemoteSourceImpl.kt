package basaraba.adndrii.movieguide.data.source.remote.tv_shows

import basaraba.adndrii.movieguide.data.api.TvShowApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.ExternalIdsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse
import basaraba.adndrii.movieguide.data.api.model.TvShowDetailsResponse
import javax.inject.Inject

class TvShowsRemoteSourceImpl @Inject constructor(
    private val api: TvShowApi
) : TvShowsRemoteSource {
    override suspend fun getTvShowDetails(tvShowId: Long): TvShowDetailsResponse =
        api.getTvShowDetails(tvShowId)

    override suspend fun getTvShowImages(tvShowId: Long): ShowImageResponse =
        api.getTvShowImages(tvShowId)

    override suspend fun getTvShowCredits(tvShowId: Long): ShowCastResponse =
        api.getTvShowCredits(tvShowId)

    override suspend fun getTvShowRecommendations(tvShowId: Long): CollectionBaseResponse<ShowResponse> =
        api.getTvShowRecommendations(tvShowId)

    override suspend fun getTvShowKeywords(tvShowId: Long): ShowKeywordsResponse =
        api.geTvShowKeywords(tvShowId)

    override suspend fun getTvShowExternalIds(tvShowId: Long): ExternalIdsResponse =
        api.getTvShowExternalIds(tvShowId)
}
