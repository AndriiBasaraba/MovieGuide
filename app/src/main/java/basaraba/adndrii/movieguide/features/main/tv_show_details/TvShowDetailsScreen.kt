package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import org.koin.androidx.compose.koinViewModel


@Composable
fun TvShowDetailsScreen(
    viewModel: TvShowDetailsViewModel = koinViewModel()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Tv show details screen = ${viewModel.tvShowId}",
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable { }
        )
    }
}
