package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonDetailsResponse(
    @SerialName("adult") val adult: Boolean,
    @SerialName("also_known_as") val alsoKnownAs: List<String>,
    @SerialName("biography") val biography: String,
    @SerialName("birthday") val birthday: String? = null,
    @SerialName("deathday") val deathday: String? = null,
    @SerialName("gender") val gender: Long,
    @SerialName("homepage") val homepage: String? = null,
    @SerialName("id") val id: Long,
    @SerialName("imdb_id") val imdbId: String? = null,
    @SerialName("known_for_department") val knownForDepartment: String,
    @SerialName("name") val name: String,
    @SerialName("place_of_birth") val placeOfBirth: String? = null,
    @SerialName("popularity") val popularity: Double,
    @SerialName("profile_path") val profilePath: String
)
