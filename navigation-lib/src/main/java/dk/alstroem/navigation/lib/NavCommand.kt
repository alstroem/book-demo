package dk.alstroem.navigation.lib

import androidx.navigation.NamedNavArgument

interface NavCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}
