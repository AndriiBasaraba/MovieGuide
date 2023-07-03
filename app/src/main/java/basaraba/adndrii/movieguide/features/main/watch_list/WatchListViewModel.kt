package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.use_case.movies.GetBookmarkedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
            getBookmarkedMoviesUseCase.invoke().onSuccess { bookmarksFlow ->
                bookmarksFlow.collect { list ->
                    println("movies from db = $list")
                    println("movies from db count = ${list.size}")
                }
            }
        }
    }
}
