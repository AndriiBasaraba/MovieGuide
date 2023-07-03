package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.MovieUiMapper
import basaraba.adndrii.movieguide.features.main.watch_list.model.WatchListState
import basaraba.adndrii.movieguide.use_case.movies.DeleteMovieBookmarkUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetBookmarkedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val getBookmarkedMoviesUseCase: GetBookmarkedMoviesUseCase,
    private val deleteMovieBookmarkUseCase: DeleteMovieBookmarkUseCase,
    private val mapper: MovieUiMapper
) : BaseViewModel<WatchListUiEvent, WatchListState>() {

    private var watchListJob: Job? = null

    private val watchList = MutableStateFlow(WatchListState())

    override val viewState: StateFlow<WatchListState> = watchList.map {
        WatchListState(
            searchQuery = it.searchQuery,
            isLoading = it.isLoading,
            isMoviesEmpty = it.isMoviesEmpty,
            isTvShowsEmpty = it.isTvShowsEmpty,
            movies = it.movies.filter { movie -> movie.title.contains(it.searchQuery, true) },
            tvShows = it.tvShows.filter { tvShow -> tvShow.title.contains(it.searchQuery, true) }
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, WatchListState())

    override fun handleEvent(event: WatchListUiEvent) {
        when (event) {
            is WatchListUiEvent.DeleteBookmark -> {
                viewModelScope.launch { deleteMovieBookmarkUseCase.invoke(event.id) }
            }

            is WatchListUiEvent.OnQueryChange -> {
                watchList.update { it.copy(searchQuery = event.text) }
            }
        }
    }

    init {
        getBookmarkedMovies()
    }

    private fun getBookmarkedMovies() {
        watchListJob?.cancel()
        watchListJob = viewModelScope.launch {
            watchList.update { it.copy(isLoading = true) }
            getBookmarkedMoviesUseCase.invoke().onSuccess { bookmarksFlow ->
                bookmarksFlow.collect { list ->
                    watchList.update {
                        it.copy(
                            isLoading = false,
                            isMoviesEmpty = list.isEmpty(),
                            movies = mapper.map(list)
                        )
                    }
                }
            }
        }
    }
}
