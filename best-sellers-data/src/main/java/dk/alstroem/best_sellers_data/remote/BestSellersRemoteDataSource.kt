package dk.alstroem.best_sellers_data.remote

import dk.alstroem.best_sellers_data.remote.model.BestSellersRemote
import io.ktor.client.call.body

class BestSellersRemoteDataSource(
    private val bestSellersService: BestSellersService
) {
    // TODO: Add error handling
    suspend fun getBestSellers(): BestSellersRemote {
        return bestSellersService.getBestSellers().body()
    }
}
