package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionBaseResponse<T>(
    @SerialName("page") val page: Long,
    @SerialName("results") val results: List<T>,
    @SerialName("total_pages") val totalPages: Long,
    @SerialName("total_results") val totalResults: Long
)
