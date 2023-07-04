package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.api.MovieApi
import basaraba.adndrii.movieguide.data.api.PersonApi
import basaraba.adndrii.movieguide.data.api.TvShowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providePersonApi(
        retrofit: Retrofit
    ): PersonApi = retrofit.create(PersonApi::class.java)

    @Provides
    @Singleton
    fun provideMovieApi(
        retrofit: Retrofit
    ): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideTvShowApi(
        retrofit: Retrofit
    ): TvShowApi = retrofit.create(TvShowApi::class.java)
}
