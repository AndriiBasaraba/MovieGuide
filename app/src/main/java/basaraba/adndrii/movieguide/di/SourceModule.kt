package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSourceImpl
import org.koin.dsl.module

object SourceModule {
    val module = module {
        single<MoviesRemoteSource> { MoviesRemoteSourceImpl(get()) }
        single<MoviesLocalSource> { MoviesLocalSourceImpl() }
    }
}
