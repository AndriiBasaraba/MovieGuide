package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoadMorePersonCard(
    onEvent: (PersonsUiEvent) -> Unit,
    isLoading: Boolean
) {
    Button(
        onClick = {
            if (isLoading.not()) onEvent(PersonsUiEvent.LoadMorePersons)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .height(64.dp),
        shape = RoundedCornerShape(50)
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
                fontWeight = FontWeight.W500
            )
        }
    }
}
