package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonCreditsResponse(
    @SerialName("cast") val cast: List<Credit>?,
    @SerialName("crew") val crew: List<Credit>?
)

@Serializable
data class Credit(
    @SerialName("id") val id: Long,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("first_air_date") val firstAirDate: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("episode_count") val episodeCount: Int? = null,
    @SerialName("character") val character: String? = null,
    @SerialName("job") val job: String? = null,
    @SerialName("vote_average") val voteAverage: Double
)
