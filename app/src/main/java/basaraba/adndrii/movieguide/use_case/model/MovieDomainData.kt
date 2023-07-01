package basaraba.adndrii.movieguide.use_case.model

data class MovieDomainData(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: String
)
