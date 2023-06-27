package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class TvShowDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tvShowId: String = checkNotNull(savedStateHandle[TV_SHOW_ID])

    companion object {
        private const val TV_SHOW_ID = "tvShowId"
    }
}
