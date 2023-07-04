package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class ShowCastResponse(
    @SerializedName("cast") val cast: List<CastCrew>?,
    @SerializedName("crew") val crew: List<CastCrew>?
)

data class CastCrew(
    @SerializedName("id") val id: Long,
    @SerializedName("known_for_department") val knownForDepartment: String,
    @SerializedName("name") val name: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("character") val character: String?,
    @SerializedName("job") val job: String?
)
