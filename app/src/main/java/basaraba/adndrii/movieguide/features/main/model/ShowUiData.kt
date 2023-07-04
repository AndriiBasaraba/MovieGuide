package basaraba.adndrii.movieguide.features.main.model

data class ShowUiData(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: String,
    val voteAverage: Double,
    val isBookmarked: Boolean,
    val type: Type?
) {
    enum class Type {
        MOVIE, TV_SHOW
    }
}
