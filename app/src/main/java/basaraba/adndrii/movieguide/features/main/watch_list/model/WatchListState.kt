package basaraba.adndrii.movieguide.features.main.watch_list.model

import basaraba.adndrii.movieguide.common.ViewState
import basaraba.adndrii.movieguide.features.main.model.ShowUiData

data class WatchListState(
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val movies: List<ShowUiData> = emptyList(),
    val tvShows: List<ShowUiData> = emptyList()
) : ViewState
