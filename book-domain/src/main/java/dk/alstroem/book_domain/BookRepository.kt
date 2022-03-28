package dk.alstroem.book_domain

import dk.alstroem.book_domain.model.BookList

interface BookRepository {
    suspend fun fetchBookList(
        encodedName: String,
        date: String,
        offset: Int
    ): BookList
}
