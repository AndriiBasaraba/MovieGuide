package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.source.local.movies.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.local.movies.MoviesLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSource
import basaraba.adndrii.movieguide.data.source.local.persons.PersonsLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.movies.MoviesRemoteSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.persons.PersonsRemoteSourceImpl
import org.koin.dsl.module

object SourceModule {
    val module = module {
        single<MoviesRemoteSource> { MoviesRemoteSourceImpl(get()) }
        single<PersonsRemoteSource> { PersonsRemoteSourceImpl(get()) }
        single<MoviesLocalSource> { MoviesLocalSourceImpl(get(), get()) }
        single<PersonsLocalSource> { PersonsLocalSourceImpl(get(), get()) }
    }
}
