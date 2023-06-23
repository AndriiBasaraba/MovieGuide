package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.features.main.movie_details.MovieDetailsViewModel
import basaraba.adndrii.movieguide.features.main.movies.MoviesViewModel
import basaraba.adndrii.movieguide.features.main.person_details.PersonDetailsViewModel
import basaraba.adndrii.movieguide.features.main.persons.PersonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val module = module {
        viewModel { MoviesViewModel(get(), get()) }
        viewModel { PersonsViewModel(get(), get(), get()) }
        viewModel { MovieDetailsViewModel(get(), get()) }
        viewModel { PersonDetailsViewModel(get()) }
    }
}
