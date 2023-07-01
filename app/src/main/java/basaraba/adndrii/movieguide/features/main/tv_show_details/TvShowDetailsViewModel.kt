package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tvShowId: String = checkNotNull(savedStateHandle[TV_SHOW_ID])
    val tvShowTitle: String = checkNotNull(savedStateHandle[TV_SHOW_TITLE])

    companion object {
        private const val TV_SHOW_ID = "tvShowId"
        private const val TV_SHOW_TITLE = "tvShowTitle"
    }
}
