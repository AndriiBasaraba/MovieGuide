package basaraba.adndrii.movieguide.features.main.movie_details.model

data class MovieDetailsUiData(
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
    val movieCollection: MovieCollection?,
    val genres: List<MovieGenre>,
    val recommendations: List<MovieUiData>,
    val keywords: List<MovieKeyword>,
    val images: List<String>,
    val movieCredits: List<MovieCast>,
    var isBookmarked: Boolean?
) {
    companion object {
        val initial = MovieDetailsUiData(
            id = -1,
            title = "",
            imdbId = "",
            overview = "",
            budget = -1,
            revenue = -1,
            poster = "",
            releaseDate = "",
            runTime = -1,
            tagLine = "",
            voteAverage = 0.0,
            voteCount = -1,
            status = "",
            isBookmarked = null,
            images = emptyList(),
            movieCollection = null,
            genres = emptyList(),
            recommendations = emptyList(),
            keywords = emptyList(),
            movieCredits = emptyList()
        )
    }
}

data class MovieCollection(
    val id: Int,
    val name: String,
    val poster: String
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
