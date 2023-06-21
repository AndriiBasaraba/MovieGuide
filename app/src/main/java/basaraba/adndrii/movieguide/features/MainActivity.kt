package basaraba.adndrii.movieguide.features

import MovieGuideTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieGuideTheme {
                Start(viewModel = koinViewModel())
            }
        }
    }
}

@Composable
fun Start(viewModel: NowPlayingMoviesViewModel) {
    Button(
        onClick = { viewModel.getNowPlayingMoviesUseCase() },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Load data from somewhere")
    }
}
