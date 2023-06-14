package basaraba.adndrii.movieguide.data

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
