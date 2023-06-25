package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class PersonsResponse(
    val id: Long,
    val name: String,
    @SerializedName("profile_path")
    val avatar: String,
    val popularity: Double,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>
)

data class KnownFor(
    @SerializedName("mediaType")
    val media_type: String,
    val name: String? = null,
    val title: String? = null
)
