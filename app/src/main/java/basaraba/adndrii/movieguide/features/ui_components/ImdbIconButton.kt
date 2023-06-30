package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.R

@Composable
fun ImdbIconButton(
    imdbId: String,
    detailsType: DetailsType,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val url =
        if (detailsType == DetailsType.PERSON) {
            BuildConfig.IMDB_PERSON_URL
        } else {
            BuildConfig.IMDB_MOVIE_URL
        }.plus(imdbId)

    IconButton(onClick = { uriHandler.openUri(url) }) {
        Image(
            painter = painterResource(R.drawable.ic_imdb),
            modifier = modifier,
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface)
        )
    }
}


enum class DetailsType {
    PERSON, SHOW
}
