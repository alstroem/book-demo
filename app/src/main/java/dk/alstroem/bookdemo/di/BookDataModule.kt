package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.alstroem.book_data.BookRepositoryImpl
import dk.alstroem.book_data.remote.BookRemoteDataSource
import dk.alstroem.book_data.remote.BookService
import dk.alstroem.book_domain.BookRepository
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookDataModule {

    @Singleton
    @Provides
    fun provideBookService(client: HttpClient) = BookService(client)

    @Singleton
    @Provides
    fun provideBookRemoteDataSource(service: BookService) = BookRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideBookRepository(remoteDataSource: BookRemoteDataSource): BookRepository {
        return BookRepositoryImpl(remoteDataSource)
    }
}
