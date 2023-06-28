package basaraba.adndrii.movieguide.features.main.persons.views.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.persons.PersonsUiEvent
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import coil.compose.AsyncImage

@Composable
fun PersonListCard(
    person: PersonUiData.Person,
    onEvent: (PersonsUiEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEvent(PersonsUiEvent.ShowPersonDetails(person.id, person.name)) }
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.onSecondary),
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
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
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp),
                        text = person.name,
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.W500,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                        text = person.knownFor,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.W400,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
