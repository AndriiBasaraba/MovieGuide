package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute

@Composable
fun PersonsScreen(
    navController: NavController,
    viewModel: PersonsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val onEvent: (PersonsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonsUiEvent.ShowPersonDetails -> {
                navController.navigate(
                    NavigationRoute.PersonDetails.getRouteNameWithArguments(
                        personId = event.id.toString(),
                        personName = event.name
                    )
                )
            }

            else -> {
                viewModel.setEvent(event)
            }
        }
    }
    PersonsScreenUi(
        onEvent = onEvent,
        viewState = viewState
    )
}
