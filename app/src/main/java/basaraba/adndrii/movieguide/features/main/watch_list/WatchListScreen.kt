package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.R

@Composable
fun WatchListScreen(
    navController: NavController
) {
    WatchListScreenUi()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchListScreenUi() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colorScheme.background,
                title = {
                    Text(
                        text = stringResource(id = R.string.watch_list),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
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
                text = "List of movies and tv shows that you saved",
                color = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}
