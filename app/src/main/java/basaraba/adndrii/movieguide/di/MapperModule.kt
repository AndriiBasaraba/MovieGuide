package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapperImpl
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapperImpl
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapperImpl
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapperImpl
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    @Singleton
    abstract fun provideMovieEntityMapper(
        movieEntityMapper: MovieEntityMapperImpl
    ): MovieEntityMapper

    @Binds
    @Singleton
    abstract fun providePersonEntityMapper(
        personEntityMapper: PersonEntityMapperImpl
    ): PersonEntityMapper

    @Binds
    @Singleton
    abstract fun provideMoviesResponseMapper(
        moviesResponseMapper: MoviesResponseMapperImpl
    ): MoviesResponseMapper

    @Binds
    @Singleton
    abstract fun providePersonsResponseMapper(
        personsResponseMapper: PersonsResponseMapperImpl
    ): PersonsResponseMapper

    @Binds
    @Singleton
    abstract fun providePersonUiMapper(
        personUiMapper: PersonUiMapperImpl
    ): PersonUiMapper
}
