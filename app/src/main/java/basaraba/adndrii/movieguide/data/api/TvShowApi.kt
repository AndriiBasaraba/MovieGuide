package basaraba.adndrii.movieguide.data.api

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.ExternalIdsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse
import basaraba.adndrii.movieguide.data.api.model.TvShowDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowApi {

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): CollectionBaseResponse<ShowResponse>

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): CollectionBaseResponse<ShowResponse>

    @GET("tv/{series_id}")
    suspend fun getTvShowDetails(
        @Path("series_id") seriesId: Long,
        @Query("language") language: String = "en-US"
    ): TvShowDetailsResponse

    @GET("tv/{series_id}/images")
    suspend fun getTvShowImages(
        @Path("series_id") seriesId: Long
    ): ShowImageResponse

    @GET("tv/{series_id}/credits")
    suspend fun getTvShowCredits(
        @Path("series_id") seriesId: Long,
        @Query("language") language: String = "en-US"
    ): ShowCastResponse

    @GET("tv/{series_id}/recommendations")
    suspend fun getTvShowRecommendations(
        @Path("series_id") seriesId: Long,
        @Query("language") language: String = "en-US"
    ): CollectionBaseResponse<ShowResponse>

    @GET("tv/{series_id}/keywords")
    suspend fun geTvShowKeywords(
        @Path("series_id") seriesId: Long,
        @Query("language") language: String = "en-US"
    ): ShowKeywordsResponse


    @GET("tv/{series_id}/external_ids")
    suspend fun getTvShowExternalIds(
        @Path("series_id") seriesId: Long
    ): ExternalIdsResponse
}
