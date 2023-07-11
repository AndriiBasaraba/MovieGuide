package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalIdsResponse(
    @SerialName("imdb_id") val imdbId: String? = null
)
