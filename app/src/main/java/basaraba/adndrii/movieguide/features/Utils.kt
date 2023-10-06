package basaraba.adndrii.movieguide.features

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import basaraba.adndrii.movieguide.features.navigation.BottomNavItem
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun getCurrentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

fun <T> List<T>.isLoadingMoreEnabled(): Boolean =
    if (this.isEmpty()) false else this.size % 20 == 0

fun <T> List<T>.getCurrentPage(): Int =
    if (this.isEmpty()) 0 else this.size / 20

fun String?.isBottomViewShown(): Boolean =
    this == BottomNavItem.ROUTE_MOVIES ||
            this == BottomNavItem.ROUTE_WATCH_LIST ||
            this == BottomNavItem.ROUTE_PERSONS ||
            this == BottomNavItem.ROUTE_TV_SHOWS

fun String.orDash(): String =
    this.ifEmpty { "--" }

fun String.isActor(): Boolean = this == "Acting"

fun String.formatDate(): String {
    if (this.isEmpty()) return ""
    val remoteFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val uiFormat = SimpleDateFormat("d MMM yyyy", Locale.ENGLISH)
    return try {
        val date = remoteFormat.parse(this)
        date?.let { uiFormat.format(it) }.orEmpty()
    } catch (e: ParseException) {
        this
    }
}
