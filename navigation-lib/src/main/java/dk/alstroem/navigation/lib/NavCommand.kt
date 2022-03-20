package dk.alstroem.navigation.lib

import androidx.navigation.NamedNavArgument

interface NavCommand {
    val destination: String
    val arguments: List<NamedNavArgument>
}
