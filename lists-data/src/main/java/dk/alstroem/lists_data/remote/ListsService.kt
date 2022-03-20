package dk.alstroem.lists_data.remote

import dk.alstroem.lists_data.remote.model.BookListRemote
import dk.alstroem.lists_data.remote.model.ListNamesRemote
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ListsService(
    private val client: HttpClient
) {

    suspend fun getListNames(): ListNamesRemote = client.get("lists/names.json")

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
