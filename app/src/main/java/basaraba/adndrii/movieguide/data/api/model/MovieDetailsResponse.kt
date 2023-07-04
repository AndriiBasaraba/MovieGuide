package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("belongs_to_collection") val belongsToCollection: MovieCollection?,
    @SerializedName("budget") val budget: Long,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("id") val id: Long,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Long,
    @SerializedName("runtime") val runtime: Long,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Long
)

data class MovieCollection(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String
)

data class Genre(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String
)
