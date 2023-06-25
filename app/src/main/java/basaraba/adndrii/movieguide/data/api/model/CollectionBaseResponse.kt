package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class CollectionBaseResponse<T>(
    val page: Long,
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long
)
