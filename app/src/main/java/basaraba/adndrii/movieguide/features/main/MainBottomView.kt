package basaraba.adndrii.movieguide.features.main

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import basaraba.adndrii.movieguide.features.getCurrentRoute
import basaraba.adndrii.movieguide.features.navigation.BottomNavItem


@Composable
fun MainBottomView(navController: NavController) {
    val bottomItems = listOf(
        BottomNavItem.Movies,
        BottomNavItem.TvShows,
        BottomNavItem.WatchList,
        BottomNavItem.Persons
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        bottomItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        fontSize = 12.sp
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.secondary,
                unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                alwaysShowLabel = true,
                selected = getCurrentRoute(navController = navController) == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
