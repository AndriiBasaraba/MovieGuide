package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsState
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType
import basaraba.adndrii.movieguide.features.ui_components.ProgressBar

@Composable
fun MovieDetailsScreeUi(
    onEvent: (MovieDetailsUiEvent) -> Unit,
    viewState: MovieDetailsState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { onEvent(MovieDetailsUiEvent.Back) },
                title = viewState.movieTitle,
                imdbId = viewState.data.imdbId,
                detailsType = DetailsType.SHOW,
                isBookmarked = viewState.data.isBookmarked,
                onBookmarkClick = { onEvent(MovieDetailsUiEvent.UpdateBookmark(it)) }
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
