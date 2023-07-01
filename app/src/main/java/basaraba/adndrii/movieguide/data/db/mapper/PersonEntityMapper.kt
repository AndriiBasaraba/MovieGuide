package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.data.db.PersonEntity
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import javax.inject.Inject

interface PersonEntityMapper {
    fun mapToDb(persons: List<PersonDomainData>): List<PersonEntity>
    fun mapFromDb(persons: List<PersonEntity>): List<PersonDomainData>
}

class PersonEntityMapperImpl @Inject constructor(): PersonEntityMapper {
    override fun mapToDb(persons: List<PersonDomainData>): List<PersonEntity> =
        persons.map {
            with(it) {
                PersonEntity(
                    id = id,
                    name = name,
                    avatar = avatar,
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
                popularity = popularity,
                knownFor = knownFor
            )
        }
    }
}
