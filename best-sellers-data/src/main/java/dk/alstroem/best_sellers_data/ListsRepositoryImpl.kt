package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.remote.ListsRemoteDataSource
import dk.alstroem.best_sellers_domain.ListsRepository
import dk.alstroem.best_sellers_domain.model.ListNames
import kotlinx.coroutines.CoroutineScope

class ListsRepositoryImpl(
    private val externalScope: CoroutineScope,
    private val listsRemoteDataSource: ListsRemoteDataSource
): ListsRepository {

    override suspend fun fetchListNames(): ListNames {
        return listsRemoteDataSource.getListNames().mapToDomain()
    }
}
