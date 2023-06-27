package basaraba.adndrii.movieguide.features.main.persons.views.grid

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent
import coil.compose.AsyncImage

@Composable
fun PersonGridCard(
    person: PersonUiData.Person,
    onEvent: (PersonsUiEvent) -> Unit
) {
    val cardWidth = (LocalConfiguration.current.screenWidthDp - 48) / 2

    Card(
        modifier = Modifier
            .width(cardWidth.dp)
            .wrapContentHeight()
            .clickable { onEvent(PersonsUiEvent.ShowPersonDetails(person.id, person.name)) },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.5.dp, Color.Gray),
        backgroundColor = Color.White,
    ) {
        Column {
            AsyncImage(
                model = person.avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(cardWidth.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                error = painterResource(id = R.drawable.ic_avatar_placeholder)
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp),
                text = person.name,
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                text = person.knownFor,
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.W400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
