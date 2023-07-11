package basaraba.adndrii.movieguide.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvShowDetailsResponse(
    @SerialName("first_air_date") val firstAirDate: String,
    @SerialName("last_air_date") val lastAirDate: String,
    @SerialName("genres") val genres: List<Genre>,
    @SerialName("id") val id: Long,
    @SerialName("imdb_id") val imdbId: String? = null,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("status") val status: String,
    @SerialName("tagline") val tagline: String,
    @SerialName("name") val name: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Long,
    @SerialName("number_of_episodes") val numberOfEpisodes: Int,
    @SerialName("number_of_seasons") val numberOfSeasons: Int,
    @SerialName("seasons") val seasons: List<SeasonResponse>
)

@Serializable
data class SeasonResponse(
    @SerialName("air_date") val airDate: String? = null,
    @SerialName("episode_count") val episodeCount: Int,
    @SerialName("name") val name: String,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("vote_average") val voteAverage: Double
)
