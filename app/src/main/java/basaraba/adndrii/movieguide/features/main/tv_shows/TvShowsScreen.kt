package basaraba.adndrii.movieguide.features.main.tv_shows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R

@Composable
fun TvShowsScreen(
    navController: NavController
) {
    TvShowsScreenUi()
}

@Composable
fun TvShowsScreenUi() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colorScheme.background,
                title = {
                    Text(
                        text = stringResource(id = R.string.tv_shows),
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            Text(
                text = "here will be list of tv shows",
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

