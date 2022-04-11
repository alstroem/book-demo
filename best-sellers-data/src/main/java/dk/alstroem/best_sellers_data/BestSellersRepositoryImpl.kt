package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.local.BestSellersDao
import dk.alstroem.best_sellers_data.remote.BestSellersRemoteDataSource
import dk.alstroem.best_sellers_domain.BestSellersRepository
import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.CoroutineScope

class BestSellersRepositoryImpl(
    private val externalScope: CoroutineScope,
    private val localDataSource: BestSellersDao,
    private val remoteDataSource: BestSellersRemoteDataSource
): BestSellersRepository {

    override suspend fun fetchBestSellers(): BestSellers {
        val bestSellers = remoteDataSource.getBestSellers()

        localDataSource.insertAllBestSellerNames(bestSellers.results.map { it.mapToEntity() })
        
        return bestSellers.mapToDomain()
    }
}
