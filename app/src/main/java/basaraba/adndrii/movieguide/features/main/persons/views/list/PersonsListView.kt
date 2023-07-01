package basaraba.adndrii.movieguide.features.main.persons.views.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.persons.model.ViewType
import basaraba.adndrii.movieguide.features.ui_components.LoadMoreCard

@Composable
fun PersonsListView(
    persons: List<PersonUiData>,
    onEvent: (PersonsUiEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(
            items = persons,
            key = { it.itemId },
            contentType = { it.viewType }
        ) {
            when (it.viewType) {
                ViewType.PERSON -> PersonListCard(
                    person = it as PersonUiData.Person,
                    onClick = { id, name -> onEvent(PersonsUiEvent.ShowPersonDetails(id, name)) }
                )

                ViewType.LOAD_MORE -> LoadMoreCard(
                    isLoading = (it as PersonUiData.LoadingMore).isLoading,
                    onClick = { onEvent(PersonsUiEvent.LoadMorePersons) }
                )
            }
        }
    }
}
