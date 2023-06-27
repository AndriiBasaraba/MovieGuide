package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsResponse(
    @SerializedName("cast") val cast: List<Credit>,
    @SerializedName("crew") val crew: List<Credit>
)

data class Credit(
    @SerializedName("id") val id: Long,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("character") val character: String?,
    @SerializedName("job") val job: String?
)
