package basaraba.adndrii.movieguide.use_case.model

data class TvShowDetailsDomainData(
    val id: Long,
    val title: String,
    val imdbId: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Long,
    val poster: String,
    val tagLine: String,
    val firstAirDate: String,
    val lastAirDate: String,
    val status: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val seasons: List<SeasonDomain>,
    val genres: List<ShowGenre>,
    val recommendations: List<ShowDomainData>,
    val keywords: List<ShowKeyword>,
    val images: List<String>,
    val tvShowCredits: List<ShowCastDomain>,
    val isBookmarked: Boolean = false
)

data class SeasonDomain(
    val airDate: String,
    val episodeCount: Int,
    val name: String,
    val posterPath: String,
    val voteAverage: Double
)
