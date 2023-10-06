package basaraba.adndrii.movieguide.features.main.image_preview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import basaraba.adndrii.movieguide.R
import coil.compose.AsyncImage

@Composable
fun ImagePreviewScreen(viewModel: ImagePreviewViewModel = hiltViewModel()) {
    AsyncImage(
        model = viewModel.url,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
        error = painterResource(id = R.drawable.ic_avatar_placeholder)
    )
}
