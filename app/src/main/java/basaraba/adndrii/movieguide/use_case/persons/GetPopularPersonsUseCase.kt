package basaraba.adndrii.movieguide.use_case.persons

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.PersonDomainData
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPopularPersonsUseCase @Inject constructor(
    private val repository: PersonsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(page: Int): Result<List<PersonDomainData>> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getPopularPersons(page = page)
            }
        }
}
