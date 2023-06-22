package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonsResponseMapper {
    fun map(response: PersonsResponse): List<PersonDomainData>
}

class PersonsResponseMapperImpl : PersonsResponseMapper {
    override fun map(response: PersonsResponse): List<PersonDomainData> =
        response.results.map {
            with(it) {
                PersonDomainData(
                    id = id,
                    name = name,
                    avatar = BuildConfig.POSTER_URL + avatar,
                    department = department
                )
            }
        }
}
