package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.Credit
import basaraba.adndrii.movieguide.data.api.model.KnownFor
import basaraba.adndrii.movieguide.data.api.model.MovieCreditsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.use_case.model.MovieRoles
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonsResponseMapper {
    fun map(response: List<PersonsResponse>): List<PersonDomainData>
    fun mapDetails(
        details: PersonDetailsResponse,
        images: PersonImagesResponse,
        movieRoles: MovieCreditsResponse
    ): PersonDetailsData
}

class PersonsResponseMapperImpl : PersonsResponseMapper {
    override fun map(response: List<PersonsResponse>): List<PersonDomainData> =
        response.map {
            with(it) {
                PersonDomainData(
                    id = id,
                    name = name,
                    avatar = BuildConfig.POSTER_URL + avatar,
                    popularity = popularity,
                    knownFor = getKnowFor(knownFor)
                )
            }
        }

    private fun getKnowFor(input: List<KnownFor>): String =
        input.map { it.name ?: it.title }.joinToString(", ")

    override fun mapDetails(
        details: PersonDetailsResponse,
        images: PersonImagesResponse,
        movieRoles: MovieCreditsResponse
    ): PersonDetailsData =
        PersonDetailsData(
            id = details.id,
            alsoKnownAs = details.alsoKnownAs,
            name = details.name,
            avatar = BuildConfig.POSTER_URL + details.profilePath,
            biography = details.biography,
            birthday = details.birthday,
            deathday = details.deathday.orEmpty(),
            placeOfBirth = details.placeOfBirth.orEmpty(),
            popularity = details.popularity,
            images = images.profiles.map { BuildConfig.POSTER_URL + it.filePath },
            movieRoles = mapMovieRoles(movieRoles)
        )

    private fun mapMovieRoles(input: MovieCreditsResponse): List<MovieRoles> =
        input.cast.map { mapMovie(it) } + input.crew.map { mapMovie(it) }

    private fun mapMovie(input: Credit): MovieRoles =
        MovieRoles(
            id = input.id,
            poster = BuildConfig.POSTER_URL + input.posterPath,
            title = input.title,
            role = input.character ?: input.job.orEmpty()
        )
}
