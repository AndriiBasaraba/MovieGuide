package basaraba.adndrii.movieguide.data.api

import basaraba.adndrii.movieguide.data.api.model.PersonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonApi {
    @GET("person/popular")
    suspend fun getPopularPersons(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): PersonsResponse
}
