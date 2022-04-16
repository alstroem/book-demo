package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBestSellersUseCase(
    private val bestSellersRepository: BestSellersRepository
) {
    operator fun invoke(): Flow<BestSellers> {
        return bestSellersRepository.bestSellers
    }
}
