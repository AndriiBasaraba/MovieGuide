package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapper
import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.watch_list.model.WatchListState
import basaraba.adndrii.movieguide.use_case.movies.DeleteShowBookmarkUseCase
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
    private val deleteShowBookmarkUseCase: DeleteShowBookmarkUseCase,
    private val mapper: ShowUiMapper
) : BaseViewModel<WatchListUiEvent, WatchListState>() {

    private var watchListJob: Job? = null

    private val watchList = MutableStateFlow(WatchListState())

    override val viewState: StateFlow<WatchListState> = watchList.map {
        WatchListState(
            searchQuery = it.searchQuery,
            isLoading = it.isLoading,
            movies = it.movies.filter { movie -> movie.title.contains(it.searchQuery, true) },
            tvShows = it.tvShows.filter { tvShow -> tvShow.title.contains(it.searchQuery, true) }
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, WatchListState())

    override fun handleEvent(event: WatchListUiEvent) {
        when (event) {
            is WatchListUiEvent.DeleteBookmark -> {
                viewModelScope.launch { deleteShowBookmarkUseCase.invoke(event.id) }
            }

            is WatchListUiEvent.OnQueryChange -> {
                watchList.update { it.copy(searchQuery = event.text) }
            }
        }
    }

    init {
        getBookmarkedShows()
    }

    private fun getBookmarkedShows() {
        watchListJob?.cancel()
        watchListJob = viewModelScope.launch {
            watchList.update { it.copy(isLoading = true) }
            getBookmarkedMoviesUseCase.invoke().onSuccess { bookmarksFlow ->
                bookmarksFlow.collect { list ->
                    val mappedList = mapper.map(list)
                    watchList.update {
                        it.copy(
                            isLoading = false,
                            movies = mappedList.filter { movie -> movie.type == ShowUiData.Type.MOVIE },
                            tvShows = mappedList.filter { tvShow -> tvShow.type == ShowUiData.Type.TV_SHOW }
                        )
                    }
                }
            }
        }
    }
}
