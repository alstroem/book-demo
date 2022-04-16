package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dk.alstroem.best_sellers_domain.BestSellersRepository
import dk.alstroem.best_sellers_domain.GetBestSellerNamesUseCase
import dk.alstroem.best_sellers_domain.GetBestSellersUseCase
import dk.alstroem.best_sellers_domain.UpdateBestSellersUseCase
import dk.alstroem.bookdemo.di.qualifier.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object BestSellersDomainModule {

    @Provides
    fun providesGetBestSellersUseCase(
        bestSellersRepository: BestSellersRepository
    ): GetBestSellersUseCase = GetBestSellersUseCase(bestSellersRepository)

    @Provides
    fun providesGetBestSellerNamesUseCase(
        bestSellersRepository: BestSellersRepository
    ): GetBestSellerNamesUseCase = GetBestSellerNamesUseCase(bestSellersRepository)

    @Provides
    fun providesUpdateBestSellersUseCase(
        bestSellersRepository: BestSellersRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): UpdateBestSellersUseCase {
        return UpdateBestSellersUseCase(bestSellersRepository, dispatcher)
    }
}
