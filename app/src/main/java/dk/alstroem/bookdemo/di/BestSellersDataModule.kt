package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.alstroem.best_sellers_data.BestSellersRepositoryImpl
import dk.alstroem.best_sellers_data.local.BestSellersDao
import dk.alstroem.best_sellers_data.remote.BestSellersRemoteDataSource
import dk.alstroem.best_sellers_data.remote.BestSellersService
import dk.alstroem.best_sellers_domain.BestSellersRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BestSellersDataModule {

    @Singleton
    @Provides
    fun provideListsService(client: HttpClient) = BestSellersService(client)

    @Singleton
    @Provides
    fun provideListsRemoteDataSource(service: BestSellersService) = BestSellersRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideListsRepository(
        externalScope: CoroutineScope,
        localDataSource: BestSellersDao,
        remoteDataSource: BestSellersRemoteDataSource
    ): BestSellersRepository {
        return BestSellersRepositoryImpl(
            externalScope = externalScope,
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }
}
