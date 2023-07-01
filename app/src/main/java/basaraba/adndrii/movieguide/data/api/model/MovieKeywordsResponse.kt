package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class MovieKeywordsResponse(
    @SerializedName("keywords") val keywords: List<Keyword>
)

data class Keyword(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String
)
