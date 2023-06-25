package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.PersonDomainData

interface PersonsRepository {
    suspend fun getPopularPersons(page: Int): List<PersonDomainData>
}
