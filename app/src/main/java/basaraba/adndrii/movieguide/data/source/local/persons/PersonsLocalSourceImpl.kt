package basaraba.adndrii.movieguide.data.source.local.persons

import basaraba.adndrii.movieguide.data.db.MovieGuideDao
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

class PersonsLocalSourceImpl(
    private val movieGuideDao: MovieGuideDao,
    private val personEntityMapper: PersonEntityMapper
) : PersonsLocalSource {
    override suspend fun getAll(): List<PersonDomainData> =
        personEntityMapper.mapFromDb(movieGuideDao.getAllPersons())

    override suspend fun insertAll(persons: List<PersonDomainData>) {
        movieGuideDao.insertAllPersons(personEntityMapper.mapToDb(persons))
    }

    override suspend fun delete() {
        movieGuideDao.deletePersons()
    }
}
