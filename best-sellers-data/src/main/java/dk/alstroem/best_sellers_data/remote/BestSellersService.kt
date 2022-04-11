package dk.alstroem.best_sellers_data.remote

import dk.alstroem.best_sellers_data.remote.model.BestSellersRemote
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BestSellersService(private val client: HttpClient) {
    suspend fun getBestSellers(): BestSellersRemote = client.get("lists/names.json")
}
