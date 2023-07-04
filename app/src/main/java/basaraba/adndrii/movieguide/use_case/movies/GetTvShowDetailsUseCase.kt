package basaraba.adndrii.movieguide.use_case.movies

import basaraba.adndrii.movieguide.di.IoDispatcher
import basaraba.adndrii.movieguide.use_case.model.TvShowDetailsDomainData
import basaraba.adndrii.movieguide.use_case.repository.TvShowsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTvShowDetailsUseCase @Inject constructor(
    private val repository: TvShowsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(tvShowId: Long): Result<TvShowDetailsDomainData> =
        withContext(ioDispatcher) {
            runCatching {
                repository.getTvShowDetails(tvShowId = tvShowId)
            }
        }
}
