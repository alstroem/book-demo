package dk.alstroem.book_data.remote

import dk.alstroem.book_data.remote.model.BookListRemote
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BookService(private val client: HttpClient) {
    /**
     * date matches ^(\d{4}-\d{2}-\d{2}) YYYY-MM-DD or 'current'
     */
    suspend fun getBookList(
        encodedName: String,
        date: String,
        offset: Int
    ): BookListRemote = client.get("lists/$date/$encodedName.json") {
        parameter("offset", offset)
    }
}
