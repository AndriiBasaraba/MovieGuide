package basaraba.adndrii.movieguide.data.source.remote.persons

import basaraba.adndrii.movieguide.data.api.PersonApi
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse

class PersonsRemoteSourceImpl(
    private val api: PersonApi
) : PersonsRemoteSource {
    override suspend fun getPopularPersons(page: Int): PersonsResponse =
        api.getPopularPersons(page = page)
}
