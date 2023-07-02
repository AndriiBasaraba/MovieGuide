package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.movies.GetBookmarkedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val getBookmarkedMoviesUseCase: GetBookmarkedMoviesUseCase
) : ViewModel() {

    init {
        getBookmarkedMovies()
    }

    private fun getBookmarkedMovies() {
        viewModelScope.launch {
            getBookmarkedMoviesUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .onEach {
                    println("movies from db = $it")
                }.launchIn(this)
        }
    }
}
