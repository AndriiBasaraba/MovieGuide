package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.persons.model.PersonsState
import basaraba.adndrii.movieguide.features.main.persons.views.grid.PersonsGridView
import basaraba.adndrii.movieguide.features.main.persons.views.list.PersonsListView

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colorScheme.background,
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_persons),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                actions = {
                    IconButton(onClick = {
                        onEvent(PersonsUiEvent.ChangeScreenView)
                    }) {
                        Image(
                            painter = painterResource(
                                if (isGridView) R.drawable.ic_list else R.drawable.ic_grid
                            ),
                            modifier = Modifier.size(24.dp),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface)
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .pullRefresh(state)
                .padding(it)
        ) {
            if (isGridView) {
                PersonsGridView(onEvent = onEvent, persons = viewState.data)
            } else {
                PersonsListView(onEvent = onEvent, persons = viewState.data)
            }
            PullRefreshIndicator(viewState.isRefreshing, state, Modifier.align(Alignment.TopCenter))
        }
    }
}
