package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.persons.model.PersonsState
import basaraba.adndrii.movieguide.features.main.persons.views.grid.PersonsGridView
import basaraba.adndrii.movieguide.features.main.persons.views.list.PersonsListView

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonsScreenUi(
    onEvent: (PersonsUiEvent) -> Unit,
    viewState: PersonsState
) {
    val state =
        rememberPullRefreshState(
            viewState.isRefreshing,
            { onEvent(PersonsUiEvent.ReloadPersonsScreen) })
    val isGridView = viewState.screenView == PersonsView.GRID

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(state)
    ) {
        if (isGridView) {
            PersonsGridView(onEvent = onEvent, persons = viewState.data)
        } else {
            PersonsListView(onEvent = onEvent, persons = viewState.data)
        }

        FloatingActionButton(
            onClick = { onEvent(PersonsUiEvent.ChangeScreenView) },
            containerColor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(end = 8.dp, bottom = 8.dp)
                .align(Alignment.BottomEnd)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.inverseSurface),
                    shape = RoundedCornerShape(50.dp)
                ),
            shape = RoundedCornerShape(50.dp),
        ) {
            Image(
                painter = painterResource(
                    if (isGridView) R.drawable.ic_list else R.drawable.ic_grid
                ),
                modifier = Modifier.size(24.dp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface)
            )
        }

        PullRefreshIndicator(viewState.isRefreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
