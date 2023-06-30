package basaraba.adndrii.movieguide.use_case.persons

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPersonDetailsUseCase @Inject constructor(
    private val repository: PersonsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(personId: Long): Result<PersonDetailsDomainData> {
        return withContext(ioDispatcher) {
            try {
                val response = repository.getPersonDetails(personId = personId)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
