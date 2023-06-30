package basaraba.adndrii.movieguide.data.source.remote.persons

import basaraba.adndrii.movieguide.data.api.PersonApi
import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import basaraba.adndrii.movieguide.data.api.model.RoleCreditsResponse
import javax.inject.Inject

class PersonsRemoteSourceImpl @Inject constructor(
    private val api: PersonApi
) : PersonsRemoteSource {
    override suspend fun getPopularPersons(page: Int): CollectionBaseResponse<PersonsResponse> =
        api.getPopularPersons(page = page)

    override suspend fun getPersonDetails(personId: Long): PersonDetailsResponse =
        api.getPersonDetails(personId = personId)

    override suspend fun getPersonImages(personId: Long): PersonImagesResponse =
        api.getPersonImages(personId = personId)

    override suspend fun getPersonMovieCredits(personId: Long): RoleCreditsResponse =
        api.getPersonMovieCredits(personId = personId)

    override suspend fun getPersonTvShowCredits(personId: Long): RoleCreditsResponse =
        api.getPersonTvShowCredits(personId = personId)
}
