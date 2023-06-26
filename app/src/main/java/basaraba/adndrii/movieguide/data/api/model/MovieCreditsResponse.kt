package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsResponse(
    val cast: List<Credit>,
    val crew: List<Credit>
)

data class Credit(
    val id: Long,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val character: String?,
    val job: String?
)
