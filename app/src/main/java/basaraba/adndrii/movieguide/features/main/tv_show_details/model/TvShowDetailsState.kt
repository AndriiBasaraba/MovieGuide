package basaraba.adndrii.movieguide.features.main.tv_show_details.model

import basaraba.adndrii.movieguide.common.ViewState

data class TvShowDetailsState(
    val isLoading: Boolean = false,
    val tvShowTitle: String = "",
    val data: TvShowDetailsUiData = TvShowDetailsUiData.initial
) : ViewState
