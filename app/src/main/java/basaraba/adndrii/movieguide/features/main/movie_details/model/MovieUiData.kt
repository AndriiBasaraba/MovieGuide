package basaraba.adndrii.movieguide.features.main.movie_details.model

data class MovieUiData(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val poster: String,
    val isBookmarked: Boolean
)
