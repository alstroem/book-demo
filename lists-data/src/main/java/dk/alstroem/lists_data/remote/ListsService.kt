package dk.alstroem.lists_data.remote

import dk.alstroem.lists_data.remote.model.ListNamesRemote
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ListsService(private val client: HttpClient) {
    suspend fun getListNames(): ListNamesRemote = client.get("lists/names.json")
}
