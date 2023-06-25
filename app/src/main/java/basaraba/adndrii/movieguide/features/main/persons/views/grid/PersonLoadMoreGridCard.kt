package basaraba.adndrii.movieguide.features.main.persons.views.grid

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent

@Composable
fun PersonLoadMoreGridCard(
    onEvent: (PersonsUiEvent) -> Unit,
    isLoading: Boolean
) {
    val cardSize = (LocalConfiguration.current.screenWidthDp - 48) / 2

    Button(
        onClick = {
            if (isLoading.not()) onEvent(PersonsUiEvent.LoadMorePersons)
        },
        modifier = Modifier
            .size(cardSize.dp),
        shape = RoundedCornerShape(12)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                color = Color.White,
                strokeWidth = 4.dp
            )
        } else {
            Text(
                text = "Load next page",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center
            )
        }
    }
}
