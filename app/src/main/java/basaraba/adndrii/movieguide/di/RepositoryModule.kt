package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.repository.MoviesRepositoryImpl
import basaraba.adndrii.movieguide.data.repository.PersonsRepositoryImpl
import basaraba.adndrii.movieguide.use_case.repository.MoviesRepository
import basaraba.adndrii.movieguide.use_case.repository.PersonsRepository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single<MoviesRepository> { MoviesRepositoryImpl(get(), get(), get()) }
        single<PersonsRepository> { PersonsRepositoryImpl(get(), get(), get()) }
    }
}
