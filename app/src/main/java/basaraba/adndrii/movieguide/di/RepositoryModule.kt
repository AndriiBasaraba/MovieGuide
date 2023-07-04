package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.repository.MoviesRepositoryImpl
import basaraba.adndrii.movieguide.data.repository.PersonsRepositoryImpl
import basaraba.adndrii.movieguide.data.repository.TvShowsRepositoryImpl
import basaraba.adndrii.movieguide.data.repository.WatchListRepositoryImpl
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import basaraba.adndrii.movieguide.use_case.repository.TvShowsRepository
import basaraba.adndrii.movieguide.use_case.repository.WatchListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideMoviesRepository(
        moviesRepository: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    @Singleton
    fun providePersonsRepository(
        personsRepository: PersonsRepositoryImpl
    ): PersonsRepository

    @Binds
    @Singleton
    fun provideWatchListRepository(
        watchListRepository: WatchListRepositoryImpl
    ): WatchListRepository

    @Binds
    @Singleton
    fun provideTvShowsRepository(
        tvShowsRepository: TvShowsRepositoryImpl
    ): TvShowsRepository
}
