package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShowImageResponse(
    @SerialName("backdrops") val backdrops: List<Backdrop>
)

@Serializable
data class Backdrop(
    @SerialName("file_path") val filePath: String
)
