package basaraba.adndrii.movieguide.data.source.local.persons

import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonsLocalSource {
    suspend fun getAll(): List<PersonDomainData>
    suspend fun insertAll(persons: List<PersonDomainData>)
    suspend fun delete()
}
