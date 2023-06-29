package basaraba.adndrii.movieguide.features.main.mapper

import basaraba.adndrii.movieguide.features.isLoadingMoreEnabled
import basaraba.adndrii.movieguide.features.main.person_details.model.PersonDetailsUiData
import basaraba.adndrii.movieguide.features.main.person_details.model.RoleCreditsUi
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.model.RoleCredits

interface PersonUiMapper {
    fun map(input: List<PersonDomainData>): List<PersonUiData>
    fun mapPersonDetails(input: PersonDetailsDomainData): PersonDetailsUiData
}

class PersonUiMapperImpl : PersonUiMapper {
    override fun map(input: List<PersonDomainData>): List<PersonUiData> {
        val mappedList = mutableListOf<PersonUiData>()

        mappedList.addAll(
            input.map {
                with(it) {
                    PersonUiData.Person(
                        id = id,
                        name = name,
                        avatar = avatar,
                        popularity = popularity,
                        knownFor = knownFor
                    )
                }
            }
        )

        if (mappedList.isLoadingMoreEnabled()) mappedList.add(PersonUiData.LoadingMore())

        return mappedList
    }

    override fun mapPersonDetails(input: PersonDetailsDomainData): PersonDetailsUiData =
        with(input) {
            PersonDetailsUiData(
                id = id,
                alsoKnownAs = alsoKnownAs,
                department = department,
                name = name,
                avatar = avatar,
                biography = biography,
                birthday = birthday,
                deathday = deathday,
                placeOfBirth = placeOfBirth,
                popularity = popularity,
                images = images,
                imdbId = imdbId,
                movieRoles = sortAndMapRoles(movieRoles),
                tvShowRoles = sortAndMapRoles(tvShowRoles)
            )
        }

    private fun sortAndMapRoles(input: List<RoleCredits>): List<RoleCreditsUi> =
        input.sortedByDescending { it.popularity }.map { credit ->
            mapRoleCredits(credit)
        }

    private fun mapRoleCredits(credit: RoleCredits) = RoleCreditsUi(
        id = credit.id,
        popularity = credit.popularity,
        poster = credit.poster,
        title = credit.title,
        role = credit.role,
        voteAverage = credit.voteAverage
    )
}
