package basaraba.adndrii.movieguide.data.api

import basaraba.adndrii.movieguide.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofitService(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    fun getPersonApi(retrofit: Retrofit): PersonApi = retrofit.create(PersonApi::class.java)

    fun getOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer ${BuildConfig.AUTH_TOKEN}"
                    )
                    .build()
                return@addInterceptor chain.proceed(newRequest)
            }
            .build()
}
