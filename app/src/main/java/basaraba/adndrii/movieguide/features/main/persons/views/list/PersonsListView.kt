package basaraba.adndrii.movieguide.features.main.persons.views.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.model.ViewType
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent

@Composable
fun PersonsListView(
    onEvent: (PersonsUiEvent) -> Unit,
    persons: List<PersonUiData>,
    state: LazyListState
) {
    LazyColumn(
        state = state,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(persons) {
            when (it.viewType) {
                ViewType.PERSON -> PersonListCard(
                    person = it as PersonUiData.Person,
                    onEvent = onEvent
                )

                ViewType.LOAD_MORE -> PersonLoadMoreListCard(
                    isLoading = (it as PersonUiData.LoadingMore).isLoading,
                    onEvent = onEvent
                )
            }
        }
    }
}
