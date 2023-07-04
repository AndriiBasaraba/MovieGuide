package basaraba.adndrii.movieguide.data.api.model

import com.google.gson.annotations.SerializedName

data class TvShowDetailsResponse(
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("last_air_date") val lastAirDate: String,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("id") val id: Long,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("name") val name: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Long,
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int,
    @SerializedName("seasons") val seasons: List<SeasonResponse>
)

data class SeasonResponse(
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode_count") val episodeCount: Int,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_average") val voteAverage: Double
)
