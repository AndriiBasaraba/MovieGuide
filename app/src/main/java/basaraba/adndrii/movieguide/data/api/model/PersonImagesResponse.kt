package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonImagesResponse(
    @SerialName("profiles") val profiles: List<Image>
)

@Serializable
data class Image(
    @SerialName("file_path") val filePath: String
)
