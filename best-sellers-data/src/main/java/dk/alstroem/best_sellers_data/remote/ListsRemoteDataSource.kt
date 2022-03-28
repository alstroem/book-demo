package dk.alstroem.best_sellers_data.remote

import dk.alstroem.best_sellers_data.remote.model.ListNamesRemote

class ListsRemoteDataSource(
    private val listsService: ListsService
) {
    // TODO: Add error handling
    suspend fun getListNames(): ListNamesRemote {
        return listsService.getListNames()
    }
}
