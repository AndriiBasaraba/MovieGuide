package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.ShowEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.ShowEntityMapperImpl
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapperImpl
import basaraba.adndrii.movieguide.data.mapper.ShowResponseMapper
import basaraba.adndrii.movieguide.data.mapper.ShowResponseMapperImpl
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapperImpl
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapper
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapperImpl
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
        movieEntityMapper: ShowEntityMapperImpl
    ): ShowEntityMapper

    @Binds
    @Singleton
    fun providePersonEntityMapper(
        personEntityMapper: PersonEntityMapperImpl
    ): PersonEntityMapper

    @Binds
    @Singleton
    fun provideShowResponseMapper(
        showResponseMapper: ShowResponseMapperImpl
    ): ShowResponseMapper

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
    fun provideShowUiMapper(
        showUiMapper: ShowUiMapperImpl
    ): ShowUiMapper
}
