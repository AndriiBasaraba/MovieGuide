package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.model.ViewType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonsScreenUi(
    onEvent: (PersonsUiEvent) -> Unit,
    persons: List<PersonUiData>,
    isRefreshing: Boolean
) {
    val state =
        rememberPullRefreshState(isRefreshing, { onEvent(PersonsUiEvent.ReloadPersonsScreen) })

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .pullRefresh(state)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(persons) {
                when (it.viewType) {
                    ViewType.PERSON -> PersonCard(
                        person = it as PersonUiData.Person,
                        onEvent = onEvent
                    )

                    ViewType.LOAD_MORE -> PersonLoadMoreCard(
                        isLoading = (it as PersonUiData.LoadingMore).isLoading,
                        onEvent = onEvent
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        PullRefreshIndicator(isRefreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
