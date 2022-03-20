package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dk.alstroem.lists_domain.GetBookListUseCase
import dk.alstroem.lists_domain.GetListNamesUseCase
import dk.alstroem.lists_domain.ListsRepository

@Module
@InstallIn(ViewModelComponent::class)
object ListsDomainModule {

    @Provides
    fun provideGetListNamesUseCase(repository: ListsRepository): GetListNamesUseCase {
        return GetListNamesUseCase(repository)
    }

    @Provides
    fun providesGetBookListUseCase(repository: ListsRepository): GetBookListUseCase {
        return GetBookListUseCase(repository)
    }
}
