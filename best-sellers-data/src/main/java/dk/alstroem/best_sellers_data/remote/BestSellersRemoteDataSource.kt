package dk.alstroem.best_sellers_data.remote

import dk.alstroem.best_sellers_data.remote.model.BestSellersRemote
import io.ktor.client.call.body

class BestSellersRemoteDataSource(
    private val bestSellersService: BestSellersService
) {
    suspend fun getBestSellers(): Result<BestSellersRemote> {
        return runCatching {
            bestSellersService.getBestSellers().body()
        }
    }
}
