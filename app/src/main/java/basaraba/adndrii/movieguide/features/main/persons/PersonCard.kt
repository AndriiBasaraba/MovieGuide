package basaraba.adndrii.movieguide.features.main.persons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.PersonUiData
import basaraba.adndrii.movieguide.features.theme.Shapes
import coil.compose.AsyncImage

@Composable
fun PersonCard(
    person: PersonUiData,
    onEvent: (PersonsUiEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEvent(PersonsUiEvent.ShowPersonDetails(person.id)) }
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .wrapContentHeight(),
        shape = Shapes.medium,
        border = BorderStroke(0.5.dp, Color.Gray),
        backgroundColor = Color.White,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                AsyncImage(
                    model = person.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                    error = painterResource(id = R.drawable.ic_avatar_placeholder)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = person.name,
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row {
                        Text(
                            text = "Department: ",
                            fontSize = 16.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.W400

                        )
                        Text(
                            text = person.department,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
            }
        }
    }
}
