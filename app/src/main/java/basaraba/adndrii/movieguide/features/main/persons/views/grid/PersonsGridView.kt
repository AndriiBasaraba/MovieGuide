package basaraba.adndrii.movieguide.features.main.persons.views.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.persons.model.ViewType
import basaraba.adndrii.movieguide.features.ui_components.LoadMoreCard

@Composable
fun PersonsGridView(
    persons: List<PersonUiData>,
    onEvent: (PersonsUiEvent) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(
            items = persons,
            key = { it.itemId },
            contentType = { it.viewType },
            span = {
                GridItemSpan(if (it.viewType == ViewType.PERSON) 1 else 2)
            }
        ) {
            when (it.viewType) {
                ViewType.PERSON -> PersonGridCard(
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
