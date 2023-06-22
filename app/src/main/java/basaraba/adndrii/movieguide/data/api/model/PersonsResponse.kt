package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class PersonsResponse(
    val page: Long,
    val results: List<Person>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)

data class Person(
    val id: Long,
    @SerializedName("known_for_department")
    val department: String,
    val name: String,
    @SerializedName("profile_path")
    val avatar: String
)
