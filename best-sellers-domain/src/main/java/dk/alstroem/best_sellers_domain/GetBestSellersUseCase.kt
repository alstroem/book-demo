package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBestSellersUseCase @Inject constructor(
    private val repository: BestSellersRepository
) {
    suspend operator fun invoke(): BestSellers = withContext(Dispatchers.IO) {
        repository.fetchBestSellers()
    }
}
