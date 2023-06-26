package basaraba.adndrii.movieguide.use_case.persons

import basaraba.adndrii.movieguide.use_case.model.PersonDetailsDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPersonDetailsUseCase(
    private val repository: PersonsRepository
) {

    suspend operator fun invoke(personId: Long): Result<PersonDetailsDomainData> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getPersonDetails(personId = personId)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
