package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class ExternalIdsResponse(
    @SerializedName("imdb_id") val imdbId: String?
)
