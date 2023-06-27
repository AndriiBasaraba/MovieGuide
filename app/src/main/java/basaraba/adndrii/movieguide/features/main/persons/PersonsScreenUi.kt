package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.persons.views.grid.PersonsGridView
import basaraba.adndrii.movieguide.features.main.persons.views.list.PersonsListView

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonsScreenUi(
    onEvent: (PersonsUiEvent) -> Unit,
    persons: List<PersonUiData>,
    isRefreshing: Boolean,
    screenView: PersonsView
) {
    val state =
        rememberPullRefreshState(isRefreshing, { onEvent(PersonsUiEvent.ReloadPersonsScreen) })
    val isGridView = screenView == PersonsView.GRID
    val listState = rememberLazyListState()
    val gridState = rememberLazyGridState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_persons),
                        color = Color.Black
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
                            contentDescription = null
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
                PersonsGridView(onEvent = onEvent, persons = persons, state = gridState)
            } else {
                PersonsListView(onEvent = onEvent, persons = persons, state = listState)
            }
            PullRefreshIndicator(isRefreshing, state, Modifier.align(Alignment.TopCenter))
        }
    }
}
