package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonsScreen(
    navController: NavController,
    viewModel: PersonsViewModel = koinViewModel()
) {
    val persons by viewModel.uiState.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val isLoadingMore by viewModel.isLoadingMore.collectAsStateWithLifecycle()

    val onEvent: (PersonsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonsUiEvent.ShowPersonDetails -> {
                navController.navigate(NavigationRoute.PersonDetails.getRouteNameWithArguments(event.id.toString()))
            }

            PersonsUiEvent.ReloadPersonsScreen -> {
                viewModel.refreshScreen()
            }

            PersonsUiEvent.LoadMorePersons -> {
                viewModel.loadNextPage()
            }
        }
    }
    PersonsScreenUi(
        onEvent = onEvent,
        persons = persons,
        isRefreshing = isRefreshing,
        isLoadingMore = isLoadingMore
    )
}
