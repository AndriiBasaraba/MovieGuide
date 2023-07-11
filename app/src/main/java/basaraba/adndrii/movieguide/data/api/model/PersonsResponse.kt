package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonsResponse(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("profile_path") val avatar: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("known_for") val knownFor: List<KnownFor>
)

@Serializable
data class KnownFor(
    @SerialName("name") val name: String? = null,
    @SerialName("title") val title: String? = null
)
