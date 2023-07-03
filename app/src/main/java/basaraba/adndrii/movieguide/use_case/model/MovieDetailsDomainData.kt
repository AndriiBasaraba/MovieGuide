package basaraba.adndrii.movieguide.use_case.model

data class MovieDetailsDomainData(
    val id: Long,
    val title: String,
    val imdbId: String,
    val overview: String,
    val budget: Long,
    val revenue: Long,
    val poster: String,
    val releaseDate: String,
    val runTime: Long,
    val tagLine: String,
    val voteAverage: Double,
    val voteCount: Long,
    val status: String,
    val movieCollection: MovieCollectionDomain?,
    val genres: List<MovieGenre>,
    val recommendations: List<MovieDomainData>,
    val keywords: List<MovieKeyword>,
    val images: List<String>,
    val movieCredits: List<MovieCastDomain>,
    val isBookmarked: Boolean = false
)

data class MovieCollectionDomain(
    val id: Int,
    val name: String,
    val posterPath: String
)

data class MovieGenre(
    val id: Long,
    val name: String
)

data class MovieCastDomain(
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
