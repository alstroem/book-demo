package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellers

interface BestSellersRepository {
    suspend fun fetchBestSellers(): BestSellers
}
