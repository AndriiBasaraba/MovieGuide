package basaraba.adndrii.movieguide.use_case.persons

import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularPersonsUseCase(
    private val repository: PersonsRepository
) {

    suspend operator fun invoke(forceReload: Boolean = false): Result<List<PersonDomainData>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.getPopularPersons(forceReload)
                Result.success(response)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
}
