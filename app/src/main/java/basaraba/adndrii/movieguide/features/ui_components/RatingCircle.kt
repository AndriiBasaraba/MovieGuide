package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun RatingCircle(
    rating: Double,
    textSize: TextUnit,
    strokeWidth: Dp,
    modifier: Modifier = Modifier
) {
    val color = when (rating) {
        0.0 -> Color.Gray
        in 0.1..3.9 -> Color.Red
        in 4.0..6.9 -> Color.Yellow
        else -> Color.Green
    }

    val colorBackground = color.copy(alpha = 0.25f)

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = "${(rating * 10).roundToInt()}",
                    fontSize = textSize,
                    color = Color.White
                )
                Text(
                    text = "%",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            CircularProgressIndicator(
                progress = 1f,
                color = colorBackground,
                modifier = Modifier.fillMaxSize(),
                strokeWidth = strokeWidth
            )

            val progress = if (rating == 0.0) 1f else rating.toFloat() / 10
            CircularProgressIndicator(
                progress = (progress),
                color = color,
                modifier = Modifier.fillMaxSize(),
                strokeWidth = strokeWidth
            )
        }
    }
}
