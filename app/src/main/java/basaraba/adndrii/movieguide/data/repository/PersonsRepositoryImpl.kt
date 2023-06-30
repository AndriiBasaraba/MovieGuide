package basaraba.adndrii.movieguide.data.repository

import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSource
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSource
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonsRepositoryImpl @Inject constructor(
    private val personsRemoteSource: PersonsRemoteSource,
    private val personsLocalSource: PersonsLocalSource,
    private val personsResponseMapper: PersonsResponseMapper
) : PersonsRepository {

    override suspend fun getPopularPersons(page: Int): List<PersonDomainData> {
        return personsResponseMapper.map(
            personsRemoteSource.getPopularPersons(page).results
        )
    }

    override suspend fun getPersonDetails(personId: Long): PersonDetailsDomainData =
        withContext(Dispatchers.IO) {
            val details = async { personsRemoteSource.getPersonDetails(personId) }
            val images = async { personsRemoteSource.getPersonImages(personId) }
            val movieCredits = async { personsRemoteSource.getPersonMovieCredits(personId) }
            val tvShowCredits = async { personsRemoteSource.getPersonTvShowCredits(personId) }

            return@withContext personsResponseMapper.mapDetails(
                details.await(),
                images.await(),
                movieCredits.await(),
                tvShowCredits.await()
            )
        }
}
