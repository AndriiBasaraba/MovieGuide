package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.MoviesRepository
import basaraba.adndrii.movieguide.data.MoviesRepositoryImpl
import basaraba.adndrii.movieguide.data.api.RetrofitClient
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSource
import basaraba.adndrii.movieguide.data.source.local.MoviesLocalSourceImpl
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSource
import basaraba.adndrii.movieguide.data.source.remote.MoviesRemoteSourceImpl
import basaraba.adndrii.movieguide.features.MovieDetailViewModel
import basaraba.adndrii.movieguide.features.NowPlayingMoviesViewModel
import basaraba.adndrii.movieguide.features.UpcomingMoviesViewModel
import basaraba.adndrii.movieguide.use_case.GetMovieDetailUseCase
import basaraba.adndrii.movieguide.use_case.GetNowPlayingMoviesUseCase
import basaraba.adndrii.movieguide.use_case.GetUpcomingMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependenciesModules {

    val apiModule = module {
        single { RetrofitClient.getRetrofitService(get()) }
        single { RetrofitClient.getService(get()) }
        single { RetrofitClient.getOkHttpClient() }
    }

    val sourceModule = module {
        single<MoviesRemoteSource> { MoviesRemoteSourceImpl(get()) }
        single<MoviesLocalSource> { MoviesLocalSourceImpl() }
    }

    val repositoriesModule = module {
        single<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
    }

    val useCasesModule = module {
        single { GetNowPlayingMoviesUseCase(get()) }
        single { GetUpcomingMoviesUseCase(get()) }
        single { GetMovieDetailUseCase(get()) }
    }

    val viewModelModule = module {
        viewModel { NowPlayingMoviesViewModel(get()) }
        viewModel { UpcomingMoviesViewModel(get()) }
        viewModel { MovieDetailViewModel(get()) }
    }
}
