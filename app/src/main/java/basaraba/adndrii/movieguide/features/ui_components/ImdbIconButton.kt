package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import basaraba.adndrii.movieguide.R

@Composable
fun ImdbIconButton(
    url: String,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    IconButton(onClick = { uriHandler.openUri(url) }) {
        Image(
            painter = painterResource(R.drawable.ic_imdb),
            modifier = modifier,
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface)
        )
    }
}
