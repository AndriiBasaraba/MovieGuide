package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.foundation.Image
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import basaraba.adndrii.movieguide.R

@Composable
fun DetailsTopBar(
    onBackClick: () -> Unit,
    title: String,
    imdbId: String,
    detailsType: DetailsType,
    isBookmarked: Boolean? = null,
    onBookmarkClick: ((Boolean) -> Unit)? = null
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.background,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackClick.invoke()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            if (detailsType == DetailsType.SHOW && isBookmarked != null) {
                IconButton(onClick = { onBookmarkClick?.invoke(isBookmarked.not()) }) {
                    Image(
                        painter = painterResource(
                            if (isBookmarked) {
                                R.drawable.ic_filled_bookmarked
                            } else {
                                R.drawable.ic_outline_bookmarked
                            }
                        ),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface)
                    )
                }
            }
            if (imdbId.isNotEmpty()) {
                ImdbIconButton(imdbId = imdbId, detailsType = detailsType)
            }
        }
    )
}
