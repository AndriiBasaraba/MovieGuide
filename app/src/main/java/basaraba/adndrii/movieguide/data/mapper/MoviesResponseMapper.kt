package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.CastCrew
import basaraba.adndrii.movieguide.data.api.model.MovieCastResponse
import basaraba.adndrii.movieguide.data.api.model.MovieDetailResponse
import basaraba.adndrii.movieguide.data.api.model.MovieImageResponse
import basaraba.adndrii.movieguide.data.api.model.MovieKeywordsResponse
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse
import basaraba.adndrii.movieguide.use_case.model.MovieCast
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieGenre
import basaraba.adndrii.movieguide.use_case.model.MovieKeyword
import javax.inject.Inject

interface MoviesResponseMapper {
    fun map(response: List<MoviesResponse>): List<MovieDomainData>
    fun mapDetails(
        details: MovieDetailResponse,
        images: MovieImageResponse,
        credits: MovieCastResponse,
        recommendations: List<MoviesResponse>,
        keywords: MovieKeywordsResponse
    ): MovieDetailsDomainData
}

class MoviesResponseMapperImpl @Inject constructor() : MoviesResponseMapper {
    override fun map(response: List<MoviesResponse>): List<MovieDomainData> =
        response.map {
            with(it) {
                MovieDomainData(
                    id = id,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate,
                    poster = BuildConfig.IMAGE_URL_SMALL + posterPath
                )
            }
        }

    override fun mapDetails(
        details: MovieDetailResponse,
        images: MovieImageResponse,
        credits: MovieCastResponse,
        recommendations: List<MoviesResponse>,
        keywords: MovieKeywordsResponse
    ): MovieDetailsDomainData =
        MovieDetailsDomainData(
            id = details.id,
            imdbId = details.imdbId.orEmpty(),
            overview = details.overview,
            budget = details.budget,
            revenue = details.revenue,
            poster = BuildConfig.IMAGE_URL_MEDIUM + details.posterPath,
            releaseDate = details.releaseDate,
            runTime = details.runtime,
            tagLine = details.tagline,
            voteAverage = details.voteAverage,
            status = details.status,
            genres = details.genres.map { MovieGenre(id = it.id, name = it.name) },
            keywords = keywords.keywords.map { MovieKeyword(id = it.id, name = it.name) }.take(5),
            images = images.backdrops.map { BuildConfig.IMAGE_URL_MEDIUM + it.filePath }.take(20),
            movieCredits = credits.cast?.map { mapCredit(it) }.orEmpty(),
            recommendations = map(recommendations).take(10)
        )

    private fun mapCredit(input: CastCrew): MovieCast =
        MovieCast(
            id = input.id,
            popularity = input.popularity,
            avatar = BuildConfig.IMAGE_URL_SMALL + input.profilePath,
            name = input.name,
            role = input.character ?: input.job.orEmpty()
        )
}
