package dk.alstroem.navigation.lib

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object NavDestinations {
    val listsNames = object : NavCommand {
        override val destination: String = "lists-names"
        override val arguments: List<NamedNavArgument> = emptyList()
    }

    val bookList = object : NavCommand {
        override val destination: String = "book-list/{listName}"
        override val arguments: List<NamedNavArgument> = listOf(
            navArgument("listName") { type = NavType.StringType }
        )
    }

    fun bookListRoute(listName: String) = "book-list/$listName"
}
