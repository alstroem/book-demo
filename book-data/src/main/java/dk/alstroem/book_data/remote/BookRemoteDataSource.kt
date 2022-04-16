package dk.alstroem.book_data.remote

import dk.alstroem.book_data.remote.model.BookListRemote
import io.ktor.client.call.body

class BookRemoteDataSource(private val bookService: BookService) {
    suspend fun getBookList(
        encodedName: String,
        date: String,
        offset: Int
    ): BookListRemote {
        return bookService.getBookList(encodedName, date, offset).body()
    }
}
