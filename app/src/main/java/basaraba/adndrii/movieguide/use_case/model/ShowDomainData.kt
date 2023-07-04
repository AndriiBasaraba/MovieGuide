package basaraba.adndrii.movieguide.use_case.model

data class ShowDomainData(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: String,
    val voteAverage: Double,
    val type: Type?,
    val isBookmarked: Boolean = false
) {
    enum class Type {
        MOVIE, TV_SHOW
    }
}
