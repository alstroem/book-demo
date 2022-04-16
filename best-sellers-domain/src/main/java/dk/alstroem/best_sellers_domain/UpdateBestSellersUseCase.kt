package dk.alstroem.best_sellers_domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateBestSellersUseCase(
    private val bestSellersRepository: BestSellersRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke() = withContext(dispatcher) {
        bestSellersRepository.updateBestSellers()
    }
}
