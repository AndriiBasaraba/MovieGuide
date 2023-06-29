package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.Credit
import basaraba.adndrii.movieguide.data.api.model.KnownFor
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.data.api.model.RoleCreditsResponse
import basaraba.adndrii.movieguide.features.isActor
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.model.RoleCredits

interface PersonsResponseMapper {
    fun map(response: List<PersonsResponse>): List<PersonDomainData>
    fun mapDetails(
        details: PersonDetailsResponse,
        images: PersonImagesResponse,
        movieRoles: RoleCreditsResponse,
        tvShowRoles: RoleCreditsResponse
    ): PersonDetailsDomainData
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
        movieRoles: RoleCreditsResponse,
        tvShowRoles: RoleCreditsResponse
    ): PersonDetailsDomainData =
        PersonDetailsDomainData(
            id = details.id,
            alsoKnownAs = details.alsoKnownAs,
            department = details.knownForDepartment,
            name = details.name,
            avatar = BuildConfig.POSTER_URL + details.profilePath,
            biography = details.biography,
            birthday = details.birthday.orEmpty(),
            deathday = details.deathday.orEmpty(),
            placeOfBirth = details.placeOfBirth.orEmpty(),
            popularity = details.popularity,
            images = images.profiles.map { BuildConfig.POSTER_URL + it.filePath },
            imdbId = details.imdbId.orEmpty(),
            movieRoles = mapRoleCredits(movieRoles, details.knownForDepartment.isActor()),
            tvShowRoles = mapRoleCredits(tvShowRoles, details.knownForDepartment.isActor())
        )

    private fun mapRoleCredits(input: RoleCreditsResponse, isActor: Boolean): List<RoleCredits> =
        if (isActor) {
            input.cast.orEmpty().map { mapCredit(it) }
        } else {
            input.crew.orEmpty().map { mapCredit(it) }
        }

    private fun mapCredit(input: Credit): RoleCredits =
        RoleCredits(
            id = input.id,
            popularity = input.popularity,
            poster = BuildConfig.POSTER_URL + input.posterPath,
            title = input.title ?: input.name.orEmpty(),
            role = input.character ?: input.job.orEmpty(),
            voteAverage = input.voteAverage
        )
}
