package dk.alstroem.lists_domain

import dk.alstroem.lists_domain.model.BookList
import dk.alstroem.lists_domain.model.ListNames

interface ListsRepository {
    suspend fun fetchListNames(): ListNames
    suspend fun fetchBookList(
        encodedName: String,
        date: String,
        offset: Int
    ): BookList
}
