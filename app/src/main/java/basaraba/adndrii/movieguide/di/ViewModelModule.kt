package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.features.MovieDetailViewModel
import basaraba.adndrii.movieguide.features.main.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { MoviesViewModel(get(), get()) }
        viewModel { MovieDetailViewModel(get()) }
    }
}
