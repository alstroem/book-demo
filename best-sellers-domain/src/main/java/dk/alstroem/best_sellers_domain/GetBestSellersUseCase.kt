package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.flow.Flow

class GetBestSellersUseCase(
    private val bestSellersRepository: BestSellersRepository
) {
    operator fun invoke(): Flow<BestSellers> {
        return bestSellersRepository.bestSellers
    }
}
