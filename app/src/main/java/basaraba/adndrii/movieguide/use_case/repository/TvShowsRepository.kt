package basaraba.adndrii.movieguide.use_case.repository

import basaraba.adndrii.movieguide.use_case.model.TvShowDetailsDomainData

interface TvShowsRepository {
    suspend fun getTvShowDetails(tvShowId: Long): TvShowDetailsDomainData
}
