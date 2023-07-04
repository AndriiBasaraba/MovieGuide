package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.CastCrew
import basaraba.adndrii.movieguide.data.api.model.MovieCollection
import basaraba.adndrii.movieguide.data.api.model.MovieDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowCastResponse
import basaraba.adndrii.movieguide.data.api.model.ShowImageResponse
import basaraba.adndrii.movieguide.data.api.model.ShowKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.ShowResponse
import basaraba.adndrii.movieguide.use_case.model.MovieCollectionDomain
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.ShowCastDomain
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import basaraba.adndrii.movieguide.use_case.model.ShowGenre
import basaraba.adndrii.movieguide.use_case.model.ShowKeyword
import javax.inject.Inject

interface ShowResponseMapper {
    fun map(response: List<ShowResponse>, type: ShowDomainData.Type): List<ShowDomainData>
    fun mapDetails(
        details: MovieDetailsResponse,
        images: ShowImageResponse,
        credits: ShowCastResponse,
        recommendations: List<ShowResponse>,
        keywords: ShowKeywordsResponse,
        isMovieBookmarked: Boolean
    ): MovieDetailsDomainData
}

class ShowResponseMapperImpl @Inject constructor() : ShowResponseMapper {
    override fun map(
        response: List<ShowResponse>,
        type: ShowDomainData.Type
    ): List<ShowDomainData> =
        response.map {
            with(it) {
                ShowDomainData(
                    id = id,
                    title = title.orEmpty(),
                    overview = overview,
                    releaseDate = releaseDate.orEmpty(),
                    voteAverage = voteAverage,
                    poster = BuildConfig.IMAGE_URL_SMALL + posterPath,
                    type = type
                )
            }
        }

    override fun mapDetails(
        details: MovieDetailsResponse,
        images: ShowImageResponse,
        credits: ShowCastResponse,
        recommendations: List<ShowResponse>,
        keywords: ShowKeywordsResponse,
        isMovieBookmarked: Boolean
    ): MovieDetailsDomainData =
        MovieDetailsDomainData(
            id = details.id,
            title = details.title,
            imdbId = details.imdbId.orEmpty(),
            overview = details.overview,
            budget = details.budget,
            revenue = details.revenue,
            poster = BuildConfig.IMAGE_URL_MEDIUM + details.posterPath,
            releaseDate = details.releaseDate,
            runTime = details.runtime,
            tagLine = details.tagline,
            voteAverage = details.voteAverage,
            voteCount = details.voteCount,
            status = details.status,
            movieCollection = mapCollection(details.belongsToCollection),
            genres = details.genres.map { ShowGenre(id = it.id, name = it.name) },
            keywords = keywords.keywords.map { ShowKeyword(id = it.id, name = it.name) }.take(5),
            images = images.backdrops.map { BuildConfig.IMAGE_URL_MEDIUM + it.filePath }.take(20),
            movieCredits = credits.cast?.map { mapCredit(it) }.orEmpty(),
            recommendations = map(recommendations, ShowDomainData.Type.MOVIE).take(10),
            isBookmarked = isMovieBookmarked
        )

    private fun mapCollection(input: MovieCollection?): MovieCollectionDomain? =
        if (input == null) null else MovieCollectionDomain(
            id = input.id,
            name = input.name,
            posterPath = BuildConfig.IMAGE_URL_MEDIUM + input.posterPath
        )

    private fun mapCredit(input: CastCrew): ShowCastDomain =
        ShowCastDomain(
            id = input.id,
            popularity = input.popularity,
            avatar = BuildConfig.IMAGE_URL_SMALL + input.profilePath,
            name = input.name,
            role = input.character ?: input.job.orEmpty()
        )
}
