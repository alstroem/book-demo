package dk.alstroem.lists_data.remote

import dk.alstroem.lists_data.remote.model.ListNamesRemote

class ListsRemoteDataSource(
    private val listsService: ListsService
) {
    // TODO: Add error handling
    suspend fun getListNames(): ListNamesRemote {
        return listsService.getListNames()
    }
}
