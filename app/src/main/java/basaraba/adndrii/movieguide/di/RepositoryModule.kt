package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.MoviesRepository
import basaraba.adndrii.movieguide.data.MoviesRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single<MoviesRepository> { MoviesRepositoryImpl(get(), get(), get()) }
    }
}
