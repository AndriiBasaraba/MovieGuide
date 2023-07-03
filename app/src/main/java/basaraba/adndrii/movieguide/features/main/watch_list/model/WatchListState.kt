package basaraba.adndrii.movieguide.features.main.watch_list.model

import basaraba.adndrii.movieguide.common.ViewState
import basaraba.adndrii.movieguide.features.main.model.MovieUiData

data class WatchListState(
    val isLoading: Boolean = false,
    val isMoviesEmpty: Boolean = false,
    val isTvShowsEmpty: Boolean = false,
    val movies: List<MovieUiData> = emptyList(),
    val tvShows: List<MovieUiData> = emptyList()
) : ViewState
