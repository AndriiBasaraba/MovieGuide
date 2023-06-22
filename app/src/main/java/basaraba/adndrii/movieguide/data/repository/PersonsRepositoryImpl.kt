package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSource
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSource
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository

class PersonsRepositoryImpl(
    private val personsRemoteSource: PersonsRemoteSource,
    private val personsLocalSource: PersonsLocalSource,
    private val personsResponseMapper: PersonsResponseMapper
) : PersonsRepository {

    override suspend fun getPopularPersons(forceReload: Boolean): List<PersonDomainData> {
        if (forceReload) {
            personsLocalSource.delete()
        }

        val personsFromDb = personsLocalSource.getAll()

        if (personsFromDb.isEmpty()) {
            val personsFromRemote = personsResponseMapper.map(
                personsRemoteSource.getPopularPersons()
            )
            personsLocalSource.insertAll(personsFromRemote)
            return personsFromRemote
        }

        return personsFromDb
    }
}
