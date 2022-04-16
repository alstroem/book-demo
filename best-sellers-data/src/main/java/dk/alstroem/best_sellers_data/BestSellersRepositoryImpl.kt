package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.local.BestSellersDao
import dk.alstroem.best_sellers_data.remote.BestSellersRemoteDataSource
import dk.alstroem.best_sellers_domain.BestSellersRepository
import dk.alstroem.best_sellers_domain.model.BestSellerName
import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BestSellersRepositoryImpl(
    private val externalScope: CoroutineScope,
    private val localDataSource: BestSellersDao,
    private val remoteDataSource: BestSellersRemoteDataSource
): BestSellersRepository {

    override val bestSellers: Flow<BestSellers>
        get() = localDataSource.getBestSellers().map { it?.mapToDomain() ?: BestSellers() }

    override val bestSellerNames: Flow<List<BestSellerName>>
        get() = localDataSource.getAllBestSellerNames().map { it.mapToDomain() }

    override suspend fun updateBestSellers() {
        val bestSellers = remoteDataSource.getBestSellers()
        val bestSellersEntity = bestSellers.mapToEntity()
        val bestSellerNamesEntity = bestSellers.results.map { it.mapToEntity() }

        localDataSource.updateBestSellers(bestSellersEntity, bestSellerNamesEntity)
    }
}
