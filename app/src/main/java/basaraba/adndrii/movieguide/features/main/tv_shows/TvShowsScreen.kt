package basaraba.adndrii.movieguide.features.main.tv_shows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TvShowsScreen(
    navController: NavController
) {
    TvShowsScreenUi()
}

@Composable
fun TvShowsScreenUi() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "here will be list of tv shows",
            color = MaterialTheme.colorScheme.inverseSurface
        )
    }
}
