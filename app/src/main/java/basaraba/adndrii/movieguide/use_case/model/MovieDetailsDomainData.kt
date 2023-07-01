package basaraba.adndrii.movieguide.use_case.model

data class MovieDetailsDomainData(
    val id: Long,
    val imdbId: String,
    val overview: String,
    val budget: Long,
    val revenue: Long,
    val poster: String,
    val releaseDate: String,
    val runTime: Long,
    val tagLine: String,
    val voteAverage: Double,
    val status: String,
    val genres: List<MovieGenre>,
    val recommendations: List<MovieDomainData>,
    val keywords: List<MovieKeyword>,
    val images: List<String>,
    val movieCredits: List<MovieCast>
)

data class MovieGenre(
    val id: Long,
    val name: String
)

data class MovieCast(
    val id: Long,
    val name: String,
    val popularity: Double,
    val avatar: String,
    val role: String
)

data class MovieKeyword(
    val id: Long,
    val name: String
)
