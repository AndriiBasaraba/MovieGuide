package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R

@Composable
fun WatchListScreen(
    navController: NavController
) {
    WatchListScreenUi()
}

@Composable
fun WatchListScreenUi() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = stringResource(id = R.string.watch_list),
                        color = Color.Black
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(it)
        ) {
            Text(text = "List of movies and tv shows that you saved", color = Color.Black)
        }
    }
}
