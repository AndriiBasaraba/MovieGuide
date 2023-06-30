package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun DetailsTopBar(
    onBackClick: () -> Unit,
    title: String,
    imdbId: String,
    detailsType: DetailsType
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
            if (imdbId.isNotEmpty()) {
                ImdbIconButton(imdbId = imdbId, detailsType = detailsType)
            }
        }
    )
}
