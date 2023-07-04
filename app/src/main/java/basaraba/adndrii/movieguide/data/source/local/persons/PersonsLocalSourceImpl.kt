package basaraba.adndrii.movieguide.data.source.local.persons

import basaraba.adndrii.movieguide.data.db.dao.PersonDao
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import javax.inject.Inject

class PersonsLocalSourceImpl @Inject constructor(
    private val personDao: PersonDao,
    private val personEntityMapper: PersonEntityMapper
) : PersonsLocalSource {
    override suspend fun getAll(): List<PersonDomainData> =
        personEntityMapper.mapFromDb(personDao.getAllPersons())

    override suspend fun insertAll(persons: List<PersonDomainData>) {
        personDao.insertAllPersons(personEntityMapper.mapToDb(persons))
    }

    override suspend fun delete() {
        personDao.deletePersons()
    }
}
