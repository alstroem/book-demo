package dk.alstroem.lists_data

import dk.alstroem.lists_data.remote.ListsRemoteDataSource
import dk.alstroem.lists_domain.ListsRepository
import dk.alstroem.lists_domain.model.BookList
import dk.alstroem.lists_domain.model.ListNames
import kotlinx.coroutines.CoroutineScope

class ListsRepositoryImpl(
    private val externalScope: CoroutineScope,
    private val listsRemoteDataSource: ListsRemoteDataSource
): ListsRepository {

    override suspend fun fetchListNames(): ListNames {
        return listsRemoteDataSource.getListNames().mapToDomain()
    }

    override suspend fun fetchBookList(encodedName: String, date: String, offset: Int): BookList {
        return listsRemoteDataSource.getBookList(encodedName, date, offset).mapToDomain()
    }
}
