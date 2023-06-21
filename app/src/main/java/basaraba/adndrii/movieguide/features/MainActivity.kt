package basaraba.adndrii.movieguide.features

import MovieGuideTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: NowPlayingMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieGuideTheme {
                Surface(
                    modifier = Modifier.wrapContentWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Start()
                }
            }
        }
    }
}

@Composable
fun Start() {
    Button(
        onClick = { },
    ) {
        Text(text = "Load data from somewhere")
    }
}
