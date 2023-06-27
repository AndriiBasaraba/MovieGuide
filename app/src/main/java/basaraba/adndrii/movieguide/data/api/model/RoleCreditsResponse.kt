package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class RoleCreditsResponse(
    @SerializedName("cast") val cast: List<Credit>?,
    @SerializedName("crew") val crew: List<Credit>?
)

data class Credit(
    @SerializedName("id") val id: Long,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("episode_count") val episodeCount: Int?,
    @SerializedName("character") val character: String?,
    @SerializedName("job") val job: String?
)
