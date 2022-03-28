package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.alstroem.best_sellers_data.ListsRepositoryImpl
import dk.alstroem.best_sellers_data.remote.ListsRemoteDataSource
import dk.alstroem.best_sellers_data.remote.ListsService
import dk.alstroem.best_sellers_domain.ListsRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ListsDataModule {

    @Singleton
    @Provides
    fun provideListsService(client: HttpClient) = ListsService(client)

    @Singleton
    @Provides
    fun provideListsRemoteDataSource(service: ListsService) = ListsRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideListsRepository(
        externalScope: CoroutineScope,
        remoteDataSource: ListsRemoteDataSource
    ): ListsRepository {
        return ListsRepositoryImpl(externalScope, remoteDataSource)
    }
}
