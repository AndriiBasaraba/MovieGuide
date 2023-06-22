package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonsScreen(
    navController: NavController,
    viewModel: PersonsViewModel = koinViewModel()
) {
    val persons by viewModel.uiState.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()

    val onEvent: (PersonsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonsUiEvent.ShowPersonDetails -> {
                navController.navigate(NavigationRoute.PersonDetails.getRouteNameWithArguments(event.id.toString()))
            }

            PersonsUiEvent.ReloadPersonsScreen -> {
                viewModel.refreshScreen()
            }
        }
    }
    PersonsScreenUi(onEvent = onEvent, persons = persons, isRefreshing = isRefreshing)
}


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
            .verticalScroll(rememberScrollState())
    ) {

        Text(text = persons.toString())
            //todo make here ui

        PullRefreshIndicator(isRefreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
