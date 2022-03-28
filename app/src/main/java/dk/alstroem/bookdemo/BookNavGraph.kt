package dk.alstroem.bookdemo

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dk.alstroem.book_ui.BookList
import dk.alstroem.listnames_ui.ListNames
import dk.alstroem.navigation.lib.NavDestinations

@Composable
fun BookNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDestinations.listsNames.destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        composable(
            route = NavDestinations.listsNames.destination,
            arguments = NavDestinations.listsNames.arguments
        ) {
            ListNames(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }

        composable(
            route = NavDestinations.bookList.destination,
            arguments = NavDestinations.bookList.arguments
        ) {
            BookList(
                navController = navController,
                viewModel = hiltViewModel(),
                encodedName = it.arguments?.getString("listName") ?: ""
            )
        }
    }
}
