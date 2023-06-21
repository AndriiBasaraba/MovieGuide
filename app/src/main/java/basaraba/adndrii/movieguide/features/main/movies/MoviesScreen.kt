package basaraba.adndrii.movieguide.features.main.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import basaraba.adndrii.movieguide.features.main.MainUiEvent

@Composable
fun MoviesScreen(onEvent: (MainUiEvent) -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "First screen",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable { }
        )
    }
}
