package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.navigation.NavigationRoute
import kotlin.random.Random

@Composable
fun PersonsScreen(navController: NavController) {
    val onEvent: (PersonsUiEvent) -> Unit = { event ->
        when (event) {
            is PersonsUiEvent.ShowPersonDetails -> {
                navController.navigate(NavigationRoute.PersonDetails.getRouteNameWithArguments(event.id.toString()))
            }

            PersonsUiEvent.ReloadPersonsScreen -> {
                // ignored
            }
        }
    }
    PersonsScreenUi(onEvent = onEvent)
}

@Composable
fun PersonsScreenUi(onEvent: (PersonsUiEvent) -> Unit) {
    Button(
        onClick = { onEvent(PersonsUiEvent.ShowPersonDetails(Random.nextInt(0, 100))) },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Click here!!")
    }
}
