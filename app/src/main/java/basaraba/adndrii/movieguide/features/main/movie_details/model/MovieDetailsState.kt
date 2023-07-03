package basaraba.adndrii.movieguide.features.main.movie_details.model

import basaraba.adndrii.movieguide.common.ViewState

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieTitle: String = "",
    val data: MovieDetailsUiData = MovieDetailsUiData.initial
) : ViewState
