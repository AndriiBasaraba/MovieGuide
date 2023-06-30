package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.ui_components.DetailsTopBar
import basaraba.adndrii.movieguide.features.ui_components.DetailsType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowDetailsScreen(
    navController: NavController,
    viewModel: TvShowDetailsViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DetailsTopBar(
                onBackClick = { navController.popBackStack() },
                title = viewModel.tvShowTitle,
                imdbId = "",
                detailsType = DetailsType.SHOW
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(
                text = "TvShow details screen = ${viewModel.tvShowId}",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
