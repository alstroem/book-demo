package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellerName
import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.flow.Flow

interface BestSellersRepository {

    val bestSellers: Flow<BestSellers>
    val bestSellerNames: Flow<List<BestSellerName>>

    suspend fun updateBestSellers()
}
