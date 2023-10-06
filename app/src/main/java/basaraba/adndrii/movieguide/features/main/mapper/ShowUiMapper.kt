package basaraba.adndrii.movieguide.features.main.mapper

import basaraba.adndrii.movieguide.features.formatDate
import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieCollection
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowCast
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowGenre
import basaraba.adndrii.movieguide.features.main.movie_details.model.ShowKeyword
import basaraba.adndrii.movieguide.features.main.tv_show_details.model.SeasonUi
import basaraba.adndrii.movieguide.features.main.tv_show_details.model.TvShowDetailsUiData
import basaraba.adndrii.movieguide.use_case.model.MovieCollectionDomain
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.ShowCastDomain
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.model.TvShowDetailsDomainData
import javax.inject.Inject

interface ShowUiMapper {
    fun map(input: List<ShowDomainData>): List<ShowUiData>
    fun mapMovieDetails(input: MovieDetailsDomainData): MovieDetailsUiData
    fun mapTvShowDetails(input: TvShowDetailsDomainData): TvShowDetailsUiData
    fun mapToDomain(input: MovieDetailsUiData): ShowDomainData
    fun mapToDomain(input: TvShowDetailsUiData): ShowDomainData
}

class ShowUiMapperImpl @Inject constructor() : ShowUiMapper {
    override fun map(input: List<ShowDomainData>): List<ShowUiData> =
        input.map {
            with(it) {
                ShowUiData(
                    id = id,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate.formatDate(),
                    poster = poster,
                    voteAverage = voteAverage,
                    isBookmarked = isBookmarked,
                    type = when (type) {
                        ShowDomainData.Type.MOVIE -> ShowUiData.Type.MOVIE
                        ShowDomainData.Type.TV_SHOW -> ShowUiData.Type.TV_SHOW
                        else -> null
                    }
                )
            }
        }

    override fun mapMovieDetails(input: MovieDetailsDomainData): MovieDetailsUiData =
        with(input) {
            MovieDetailsUiData(
                id = id,
                title = title,
                imdbId = imdbId,
                overview = overview,
                budget = budget,
                revenue = revenue,
                poster = poster,
                releaseDate = releaseDate.formatDate(),
                runTime = runTime,
                tagLine = tagLine,
                voteAverage = voteAverage,
                voteCount = voteCount,
                status = status,
                isBookmarked = isBookmarked,
                images = images,
                movieCollection = mapCollection(movieCollection),
                genres = genres.map { genre -> ShowGenre(genre.id, genre.name) },
                recommendations = map(recommendations),
                keywords = keywords.map { keyword -> ShowKeyword(keyword.id, keyword.name) },
                movieCredits = movieCredits.map { credit -> mapShowCredits(credit) }
            )
        }

    private fun mapCollection(input: MovieCollectionDomain?): MovieCollection? =
        if (input == null) null else MovieCollection(
            id = input.id,
            name = input.name,
            poster = input.posterPath
        )

    override fun mapTvShowDetails(input: TvShowDetailsDomainData): TvShowDetailsUiData =
        with(input) {
            TvShowDetailsUiData(
                id = id,
                title = title,
                imdbId = imdbId,
                overview = overview,
                poster = poster,
                firstAirDate = firstAirDate.formatDate(),
                lastAirDate = lastAirDate.formatDate(),
                tagLine = tagLine,
                voteAverage = voteAverage,
                voteCount = voteCount,
                status = status,
                isBookmarked = isBookmarked,
                images = images,
                genres = genres.map { genre -> ShowGenre(genre.id, genre.name) },
                recommendations = map(recommendations),
                keywords = keywords.map { keyword -> ShowKeyword(keyword.id, keyword.name) },
                tvShowCredits = tvShowCredits.map { credit -> mapShowCredits(credit) },
                numberOfEpisodes = numberOfEpisodes,
                numberOfSeasons = numberOfSeasons,
                seasons = seasons.map { season ->
                    SeasonUi(
                        airDate = season.airDate.formatDate(),
                        episodeCount = season.episodeCount,
                        name = season.name,
                        posterPath = season.posterPath,
                        voteAverage = season.voteAverage
                    )
                }
            )
        }

    private fun mapShowCredits(input: ShowCastDomain): ShowCast =
        with(input) {
            ShowCast(
                id = id,
                name = name,
                popularity = popularity,
                avatar = avatar,
                role = role
            )
        }

    override fun mapToDomain(input: MovieDetailsUiData): ShowDomainData =
        with(input) {
            ShowDomainData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                voteAverage = voteAverage,
                type = ShowDomainData.Type.MOVIE,
                isBookmarked = true
            )
        }

    override fun mapToDomain(input: TvShowDetailsUiData): ShowDomainData =
        with(input) {
            ShowDomainData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = firstAirDate,
                poster = poster,
                voteAverage = voteAverage,
                type = ShowDomainData.Type.TV_SHOW,
                isBookmarked = true
            )
        }
}
