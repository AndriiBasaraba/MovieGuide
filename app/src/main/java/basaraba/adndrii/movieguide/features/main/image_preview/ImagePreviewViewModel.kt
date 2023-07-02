package basaraba.adndrii.movieguide.features.main.image_preview

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagePreviewViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val url = checkNotNull(savedStateHandle[URL]).toString()

    companion object {
        private const val URL = "url"
    }

}
