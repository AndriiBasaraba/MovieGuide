package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShowCastResponse(
    @SerialName("cast") val cast: List<CastCrew>?,
    @SerialName("crew") val crew: List<CastCrew>?
)

@Serializable
data class CastCrew(
    @SerialName("id") val id: Long,
    @SerialName("known_for_department") val knownForDepartment: String,
    @SerialName("name") val name: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("profile_path") val profilePath: String? = null,
    @SerialName("character") val character: String? = null,
    @SerialName("job") val job: String? = null
)
