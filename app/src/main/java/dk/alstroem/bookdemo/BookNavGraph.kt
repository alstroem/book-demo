package dk.alstroem.bookdemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import dk.alstroem.navigation.lib.NavDestinations
import dk.alstroem.navigation.lib.NavManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun BookNavGraph(
    modifier: Modifier = Modifier,
    navManager: NavManager = NavManager(),
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDestinations.listsNames.destination
) {
    LaunchedEffect("navigation") {
        navManager.command.onEach {
            navController.navigate(it.destination)
        }.launchIn(this)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(NavDestinations.listsNames.destination) {

        }
    }
}
