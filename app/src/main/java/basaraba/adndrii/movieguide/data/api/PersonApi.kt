package basaraba.adndrii.movieguide.data.api

import basaraba.adndrii.movieguide.data.api.model.CollectionBaseResponse
import basaraba.adndrii.movieguide.data.api.model.MovieCreditsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonDetailsResponse
import basaraba.adndrii.movieguide.data.api.model.PersonImagesResponse
import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonApi {
    @GET("person/popular")
    suspend fun getPopularPersons(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): CollectionBaseResponse<PersonsResponse>

    @GET("person/{person_id}")
    suspend fun getPersonDetails(
        @Path("person_id") personId: Long,
        @Query("language") language: String = "en-US"
    ): PersonDetailsResponse

    @GET("person/{person_id}/images")
    suspend fun getPersonImages(
        @Path("person_id") personId: Long,
        @Query("language") language: String = "en-US"
    ): PersonImagesResponse

    @GET("person/{person_id}/movie_credits")
    suspend fun getPersonMovieCredits(
        @Path("person_id") personId: Long,
        @Query("language") language: String = "en-US"
    ): MovieCreditsResponse
}
