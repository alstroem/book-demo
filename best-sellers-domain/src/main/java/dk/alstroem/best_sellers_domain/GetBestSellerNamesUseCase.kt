package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellerName
import kotlinx.coroutines.flow.Flow

class GetBestSellerNamesUseCase(
    private val bestSellersRepository: BestSellersRepository
) {
    operator fun invoke(): Flow<List<BestSellerName>> {
        return bestSellersRepository.bestSellerNames
    }
}
