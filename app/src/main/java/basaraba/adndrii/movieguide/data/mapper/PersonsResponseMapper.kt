package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.Credit
import basaraba.adndrii.movieguide.data.api.model.KnownFor
import basaraba.adndrii.movieguide.data.api.model.PersonCreditsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.features.isActor
import basaraba.adndrii.movieguide.use_case.model.PersonCredits
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import javax.inject.Inject

interface PersonsResponseMapper {
    fun map(response: List<PersonsResponse>): List<PersonDomainData>
    fun mapDetails(
        details: PersonDetailsResponse,
        images: PersonImagesResponse,
        movieRoles: PersonCreditsResponse,
        tvShowRoles: PersonCreditsResponse
    ): PersonDetailsDomainData
}

class PersonsResponseMapperImpl @Inject constructor() : PersonsResponseMapper {
    override fun map(response: List<PersonsResponse>): List<PersonDomainData> =
        response.map {
            with(it) {
                PersonDomainData(
                    id = id,
                    name = name,
                    avatar = BuildConfig.IMAGE_URL_SMALL + avatar,
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
        movieRoles: PersonCreditsResponse,
        tvShowRoles: PersonCreditsResponse
    ): PersonDetailsDomainData =
        PersonDetailsDomainData(
            id = details.id,
            alsoKnownAs = details.alsoKnownAs,
            department = details.knownForDepartment,
            name = details.name,
            avatar = BuildConfig.IMAGE_URL_MEDIUM + details.profilePath,
            biography = details.biography,
            birthday = details.birthday.orEmpty(),
            deathday = details.deathday.orEmpty(),
            placeOfBirth = details.placeOfBirth.orEmpty(),
            popularity = details.popularity,
            images = images.profiles.map { BuildConfig.IMAGE_URL_MEDIUM + it.filePath },
            imdbId = details.imdbId.orEmpty(),
            movieRoles = mapRoleCredits(movieRoles, details.knownForDepartment.isActor()),
            tvShowRoles = mapRoleCredits(tvShowRoles, details.knownForDepartment.isActor())
        )

    private fun mapRoleCredits(
        input: PersonCreditsResponse,
        isActor: Boolean
    ): List<PersonCredits> =
        if (isActor) {
            input.cast.orEmpty().map { mapCredit(it) }
        } else {
            input.crew.orEmpty().map { mapCredit(it) }
        }

    private fun mapCredit(input: Credit): PersonCredits =
        PersonCredits(
            id = input.id,
            popularity = input.popularity,
            poster = BuildConfig.IMAGE_URL_SMALL + input.posterPath,
            title = input.title ?: input.name.orEmpty(),
            role = input.character ?: input.job.orEmpty(),
            voteAverage = input.voteAverage
        )
}
