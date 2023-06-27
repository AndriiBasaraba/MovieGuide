package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class PersonsResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("profile_path") val avatar: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("known_for") val knownFor: List<KnownFor>
)

data class KnownFor(
    @SerializedName("name") val name: String? = null,
    @SerializedName("title") val title: String? = null
)
