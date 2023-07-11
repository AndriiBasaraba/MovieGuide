package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsResponse(
    @SerialName("belongs_to_collection") val belongsToCollection: MovieCollection?,
    @SerialName("budget") val budget: Long,
    @SerialName("genres") val genres: List<Genre>,
    @SerialName("id") val id: Long,
    @SerialName("imdb_id") val imdbId: String? = null,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("revenue") val revenue: Long,
    @SerialName("runtime") val runtime: Long,
    @SerialName("status") val status: String,
    @SerialName("tagline") val tagline: String,
    @SerialName("title") val title: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Long
)

@Serializable
data class MovieCollection(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("backdrop_path") val backdropPath: String
)

@Serializable
data class Genre(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String
)
