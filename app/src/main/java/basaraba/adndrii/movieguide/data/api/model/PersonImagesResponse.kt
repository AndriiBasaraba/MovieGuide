package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class PersonImagesResponse(
    val profiles: List<Image>
)

data class Image(
    @SerializedName("file_path") val filePath: String
)