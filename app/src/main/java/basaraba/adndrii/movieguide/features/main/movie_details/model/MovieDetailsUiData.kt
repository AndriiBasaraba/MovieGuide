package basaraba.adndrii.movieguide.features.main.movie_details.model

import basaraba.adndrii.movieguide.features.main.model.ShowUiData

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
    val genres: List<ShowGenre>,
    val recommendations: List<ShowUiData>,
    val keywords: List<ShowKeyword>,
    val images: List<String>,
    val movieCredits: List<ShowCast>,
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

data class ShowGenre(
    val id: Long,
    val name: String
)

data class ShowCast(
    val id: Long,
    val name: String,
    val popularity: Double,
    val avatar: String,
    val role: String
)

data class ShowKeyword(
    val id: Long,
    val name: String
)
