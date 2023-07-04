package basaraba.adndrii.movieguide.features.main.tv_show_details.model

import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowCast
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowGenre
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowKeyword

data class TvShowDetailsUiData(
    val id: Long,
    val title: String,
    val imdbId: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Long,
    val poster: String,
    val tagLine: String,
    val firstAirDate: String,
    val lastAirDate: String,
    val status: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val seasons: List<SeasonUi>,
    val genres: List<ShowGenre>,
    val recommendations: List<ShowUiData>,
    val keywords: List<ShowKeyword>,
    val images: List<String>,
    val tvShowCredits: List<ShowCast>,
    val isBookmarked: Boolean?
) {
    companion object {
        val initial = TvShowDetailsUiData(
            id = -1,
            title = "",
            imdbId = "",
            overview = "",
            poster = "",
            tagLine = "",
            voteAverage = 0.0,
            voteCount = -1,
            status = "",
            isBookmarked = null,
            images = emptyList(),
            genres = emptyList(),
            recommendations = emptyList(),
            keywords = emptyList(),
            tvShowCredits = emptyList(),
            firstAirDate = "",
            lastAirDate = "",
            seasons = emptyList(),
            numberOfSeasons = -1,
            numberOfEpisodes = -1
        )
    }
}

data class SeasonUi(
    val airDate: String,
    val episodeCount: Int,
    val name: String,
    val posterPath: String,
    val voteAverage: Double
)
