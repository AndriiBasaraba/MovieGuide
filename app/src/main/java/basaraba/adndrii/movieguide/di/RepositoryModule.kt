package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.repository.MoviesRepositoryImpl
import basaraba.adndrii.movieguide.data.repository.PersonsRepositoryImpl
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideMoviesRepository(
        moviesRepository: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    @Singleton
    abstract fun providePersonsRepository(
        personsRepository: PersonsRepositoryImpl
    ): PersonsRepository

}
