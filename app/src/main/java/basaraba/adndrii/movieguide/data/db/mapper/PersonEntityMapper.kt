package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.data.db.PersonEntity
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonEntityMapper {
    fun mapToDb(persons: List<PersonDomainData>): List<PersonEntity>
    fun mapFromDb(persons: List<PersonEntity>): List<PersonDomainData>
}

class PersonEntityMapperImpl : PersonEntityMapper {
    override fun mapToDb(persons: List<PersonDomainData>): List<PersonEntity> =
        persons.map {
            with(it) {
                PersonEntity(
                    id = id,
                    name = name,
                    avatar = avatar,
                    department = department,
                    popularity = popularity,
                    knownFor = knownFor
                )
            }
        }

    override fun mapFromDb(persons: List<PersonEntity>): List<PersonDomainData> = persons.map {
        with(it) {
            PersonDomainData(
                id = id,
                name = name,
                avatar = avatar,
                department = department,
                popularity = popularity,
                knownFor = knownFor
            )
        }
    }
}
