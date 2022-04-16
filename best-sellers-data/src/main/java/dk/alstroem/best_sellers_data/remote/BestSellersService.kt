package dk.alstroem.best_sellers_data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class BestSellersService(private val client: HttpClient) {
    suspend fun getBestSellers(): HttpResponse = client.get("lists/names.json")
}
