package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.theme.Shapes

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
                PersonCard(person = it, onEvent = onEvent)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        PullRefreshIndicator(isRefreshing, state, Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun PersonCard(
    person: PersonUiData,
    onEvent: (PersonsUiEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEvent(PersonsUiEvent.ShowPersonDetails(person.id)) }
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .wrapContentHeight(),
        shape = Shapes.medium,
        border = BorderStroke(0.5.dp, Color.Gray),
        backgroundColor = Color.White,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = person.id.toString())
            Text(text = person.name)
            Text(text = person.avatar)
            Text(text = person.department)
        }
    }
}
