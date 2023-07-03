package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapperImpl
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapperImpl
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapperImpl
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapperImpl
import basaraba.adndrii.movieguide.features.main.mapper.MovieUiMapper
import basaraba.adndrii.movieguide.features.main.mapper.MovieUiMapperImpl
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    @Singleton
    fun provideMovieEntityMapper(
        movieEntityMapper: MovieEntityMapperImpl
    ): MovieEntityMapper

    @Binds
    @Singleton
    fun providePersonEntityMapper(
        personEntityMapper: PersonEntityMapperImpl
    ): PersonEntityMapper

    @Binds
    @Singleton
    fun provideMoviesResponseMapper(
        moviesResponseMapper: MoviesResponseMapperImpl
    ): MoviesResponseMapper

    @Binds
    @Singleton
    fun providePersonsResponseMapper(
        personsResponseMapper: PersonsResponseMapperImpl
    ): PersonsResponseMapper

    @Binds
    @Singleton
    fun providePersonUiMapper(
        personUiMapper: PersonUiMapperImpl
    ): PersonUiMapper

    @Binds
    @Singleton
    fun provideMovieUiMapper(
        movieUiMapper: MovieUiMapperImpl
    ): MovieUiMapper
}
