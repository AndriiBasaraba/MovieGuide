package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.features.MovieDetailViewModel
import basaraba.adndrii.movieguide.features.NowPlayingMoviesViewModel
import basaraba.adndrii.movieguide.features.UpcomingMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { NowPlayingMoviesViewModel(get()) }
        viewModel { UpcomingMoviesViewModel(get()) }
        viewModel { MovieDetailViewModel(get()) }
    }
}
