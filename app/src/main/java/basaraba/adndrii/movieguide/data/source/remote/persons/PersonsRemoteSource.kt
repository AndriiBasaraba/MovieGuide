package basaraba.adndrii.movieguide.data.source.remote.persons

import basaraba.adndrii.movieguide.data.api.model.PersonsResponse

interface PersonsRemoteSource {
    suspend fun getPopularPersons(): PersonsResponse
}
