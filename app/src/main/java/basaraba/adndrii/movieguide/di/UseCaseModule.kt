package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.use_case.movies.GetMovieDetailUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetUpcomingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.persons.GetMorePopularPersonsUseCase
import basaraba.adndrii.movieguide.use_case.persons.GetPopularPersonsUseCase
import org.koin.dsl.module

object UseCaseModule {
    val module = module {
        single { GetNowPlayingMoviesUseCase(get()) }
        single { GetUpcomingMoviesUseCase(get()) }
        single { GetMovieDetailUseCase(get()) }
        single { GetPopularPersonsUseCase(get()) }
        single { GetMorePopularPersonsUseCase(get()) }
    }
}
