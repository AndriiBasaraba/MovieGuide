package basaraba.adndrii.movieguide.features.main.mapper

import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonUiMapper {
    fun map(input: List<PersonDomainData>): List<PersonUiData>
}

class PersonUiMapperImpl : PersonUiMapper {
    override fun map(input: List<PersonDomainData>): List<PersonUiData> =
        input.map {
            with(it) {
                PersonUiData(
                    id = id,
                    name = name,
                    avatar = avatar,
                    department = department
                )
            }
        }
}
