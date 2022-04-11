package dk.alstroem.bookdemo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dk.alstroem.best_sellers_data.local.BestSellersDao
import dk.alstroem.bookdemo.AppDatabase
import dk.alstroem.bookdemo.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun providesBestSellersDao(appDatabase: AppDatabase): BestSellersDao {
        return appDatabase.bestSellersDao()
    }
}
