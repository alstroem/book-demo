package dk.alstroem.book_data

import dk.alstroem.book_data.remote.BookRemoteDataSource
import dk.alstroem.book_domain.BookRepository
import dk.alstroem.book_domain.model.BookList

class BookRepositoryImpl(
    private val remoteDataSource: BookRemoteDataSource
): BookRepository {
    override suspend fun fetchBookList(encodedName: String, date: String, offset: Int): BookList {
        return remoteDataSource.getBookList(encodedName, date, offset).mapToDomain()
    }
}
