package basaraba.adndrii.movieguide.features.main.persons.views.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.model.ViewType
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent

@Composable
fun PersonsGridView(
    onEvent: (PersonsUiEvent) -> Unit,
    persons: List<PersonUiData>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(persons) {
            when (it.viewType) {
                ViewType.PERSON -> PersonGridCard(
                    person = it as PersonUiData.Person,
                    onEvent = onEvent
                )

                ViewType.LOAD_MORE -> PersonLoadMoreGridCard(
                    isLoading = (it as PersonUiData.LoadingMore).isLoading,
                    onEvent = onEvent
                )
            }
        }
    }
}
