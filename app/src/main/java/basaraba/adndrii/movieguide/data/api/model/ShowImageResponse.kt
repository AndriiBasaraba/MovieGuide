package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class ShowImageResponse(
    @SerializedName("backdrops") val backdrops: List<Backdrop>
)

data class Backdrop(
    @SerializedName("file_path") val filePath: String
)
