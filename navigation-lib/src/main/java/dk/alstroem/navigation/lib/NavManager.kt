package dk.alstroem.navigation.lib

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class NavManager {

    private val _command = MutableSharedFlow<NavCommand>()
    val command: SharedFlow<NavCommand> = _command

    fun navigate(directions: NavCommand) {
        _command.tryEmit(directions)
    }
}
