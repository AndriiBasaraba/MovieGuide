package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import basaraba.adndrii.movieguide.features.main.tv_show_details.model.TvShowDetailsState
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType
import basaraba.adndrii.movieguide.features.ui_components.ProgressBar

@Composable
fun TvShowDetailsScreenUi(
    onEvent: (TvShowDetailsUiEvent) -> Unit,
    viewState: TvShowDetailsState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { onEvent(TvShowDetailsUiEvent.Back) },
                title = viewState.tvShowTitle,
                imdbId = viewState.data.imdbId,
                detailsType = DetailsType.SHOW,
                isBookmarked = viewState.data.isBookmarked,
                onBookmarkClick = { onEvent(TvShowDetailsUiEvent.UpdateBookmark(it)) }
            )
        }
    ) {
        if (viewState.isLoading) {
            ProgressBar()
        } else {
            it
        }

    }
}
