package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.KnownFor
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonsResponseMapper {
    fun map(response: List<PersonsResponse>): List<PersonDomainData>
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
}
