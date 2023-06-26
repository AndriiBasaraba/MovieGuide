package basaraba.adndrii.movieguide.features.main.mapper

import basaraba.adndrii.movieguide.features.isLoadingMoreEnabled
import basaraba.adndrii.movieguide.features.main.model.MovieRoles
import basaraba.adndrii.movieguide.features.main.model.PersonDetailsUiData
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

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
                movieRoles = movieRoles.sortedByDescending { it.popularity } .map { credit ->
                    MovieRoles(
                        id = credit.id,
                        popularity = credit.popularity,
                        poster = credit.poster,
                        title = credit.title,
                        role = credit.role
                    )
                }
            )
        }
}
