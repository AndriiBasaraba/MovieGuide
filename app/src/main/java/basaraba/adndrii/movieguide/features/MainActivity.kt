package basaraba.adndrii.movieguide.features

import MovieGuideTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import basaraba.adndrii.movieguide.features.main.MainBottomView
import basaraba.adndrii.movieguide.features.navigation.AppNavigation
import basaraba.adndrii.movieguide.features.navigation.BottomNavItem

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SetContent() }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SetContent() {
        MovieGuideTheme {
            val navController = rememberNavController()
            val currentRoute = getCurrentRoute(navController)

            Scaffold(bottomBar = {
                if (currentRoute == BottomNavItem.ROUTE_MOVIES || currentRoute == BottomNavItem.ROUTE_PERSONS) {
                    MainBottomView(navController = navController)
                }
            }) {
                AppNavigation(navController = navController, modifier = Modifier.padding(it))
            }
        }
    }
}
