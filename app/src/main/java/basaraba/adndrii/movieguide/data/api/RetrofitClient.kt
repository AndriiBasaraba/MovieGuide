package basaraba.adndrii.movieguide.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofitService(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getService(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

    fun getOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZTgzMDc2OTE4M2FmYTIwY2UyZDVmNWYxYTFmMjIxNiIsInN1YiI6IjU4ZGNlMWE3YzNhMzY4MjIzZTAwOTU5NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hqdhR1VshLz4mPhToKr9YaPGpNNrSfpwlOeTJsTyffU"
                    )
                    .build()
                return@addInterceptor chain.proceed(newRequest)
            }
            .build()

    private const val BASE_URL = "https://api.themoviedb.org/3/"
}
