package dk.alstroem.navigation.lib

import androidx.navigation.NamedNavArgument

object NavDestinations {
    val listsNames = object : NavCommand {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "lists-names"
    }
}
