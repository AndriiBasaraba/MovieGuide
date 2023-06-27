package basaraba.adndrii.movieguide.data.source.remote.persons

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.RoleCreditsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse

interface PersonsRemoteSource {
    suspend fun getPopularPersons(page: Int = 1): CollectionBaseResponse<PersonsResponse>
    suspend fun getPersonDetails(personId: Long): PersonDetailsResponse
    suspend fun getPersonImages(personId: Long): PersonImagesResponse
    suspend fun getPersonMovieCredits(personId: Long): RoleCreditsResponse
    suspend fun getPersonTvShowCredits(personId: Long): RoleCreditsResponse
}
