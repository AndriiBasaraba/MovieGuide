package basaraba.adndrii.movieguide.use_case.model

data class MovieShortData(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: String,
    val type: Type?
) {
    enum class Type {
        Ongoing, Upcoming
    }
}
