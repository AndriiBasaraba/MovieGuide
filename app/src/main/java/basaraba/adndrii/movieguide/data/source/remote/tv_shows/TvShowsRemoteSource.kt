package basaraba.adndrii.movieguide.data.source.remote.tv_shows

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.ExternalIdsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse
import basaraba.adndrii.movieguide.data.api.model.TvShowDetailsResponse

interface TvShowsRemoteSource {
    suspend fun getTvShowDetails(tvShowId: Long): TvShowDetailsResponse
    suspend fun getTvShowImages(tvShowId: Long): ShowImageResponse
    suspend fun getTvShowCredits(tvShowId: Long): ShowCastResponse
    suspend fun getTvShowRecommendations(tvShowId: Long): CollectionBaseResponse<ShowResponse>
    suspend fun getTvShowKeywords(tvShowId: Long): ShowKeywordsResponse
    suspend fun getTvShowExternalIds(tvShowId: Long): ExternalIdsResponse
}
