package basaraba.adndrii.movieguide.features.main.persons.views.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.persons.model.PersonUiData
import coil.compose.AsyncImage

@Composable
fun PersonGridCard(
    person: PersonUiData.Person,
    onClick: (Long, String) -> Unit
) {
    val cardWidth = (LocalConfiguration.current.screenWidthDp - 48) / 2

    Card(
        modifier = Modifier
            .width(cardWidth.dp)
            .wrapContentHeight()
            .clickable { onClick.invoke(person.id, person.name) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            AsyncImage(
                model = person.avatar,
                contentDescription = null,
                modifier = Modifier.size(cardWidth.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_avatar_placeholder),
                error = painterResource(id = R.drawable.ic_avatar_placeholder)
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp),
                text = person.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                text = person.knownFor,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
