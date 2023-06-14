package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.use_case.GetMovieDetailUseCase
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.GetUpcomingMoviesUseCase
import org.koin.dsl.module

object UseCaseModule {
    val module = module {
        single { GetNowPlayingMoviesUseCase(get()) }
        single { GetUpcomingMoviesUseCase(get()) }
        single { GetMovieDetailUseCase(get()) }
    }
}
