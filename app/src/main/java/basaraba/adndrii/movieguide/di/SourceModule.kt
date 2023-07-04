package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.source.local.shows.ShowsLocalSource
import basaraba.adndrii.movieguide.data.source.local.shows.ShowsLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSource
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.tv_shows.TvShowsRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.tv_shows.TvShowsRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SourceModule {

    @Binds
    @Singleton
    fun provideMoviesRemoteSource(
        moviesRemoteSource: MoviesRemoteSourceImpl
    ): MoviesRemoteSource

    @Binds
    @Singleton
    fun provideShowLocalSource(
        showLocalDataSource: ShowsLocalSourceImpl
    ): ShowsLocalSource

    @Binds
    @Singleton
    fun providePersonsRemoteSource(
        personsRemoteSource: PersonsRemoteSourceImpl
    ): PersonsRemoteSource

    @Binds
    @Singleton
    fun providePersonsLocalSource(
        personsLocalSource: PersonsLocalSourceImpl
    ): PersonsLocalSource

    @Binds
    @Singleton
    fun provideTvShowsRemoteSource(
        tvShowsRemoteSource: TvShowsRemoteSourceImpl
    ): TvShowsRemoteSource
}
