package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.api.RetrofitClient
import org.koin.dsl.module

object ApiModule {
    val module = module {
        single { RetrofitClient.getRetrofitService(get()) }
        single { RetrofitClient.getService(get()) }
        single { RetrofitClient.getOkHttpClient() }
    }
}
