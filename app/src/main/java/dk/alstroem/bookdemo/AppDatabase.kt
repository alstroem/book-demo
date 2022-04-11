package dk.alstroem.bookdemo

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dk.alstroem.best_sellers_data.local.BestSellersDao
import dk.alstroem.best_sellers_data.local.Converters
import dk.alstroem.best_sellers_data.local.model.BestSellerNameEntity
import dk.alstroem.best_sellers_data.local.model.BestSellersEntity

const val DATABASE_NAME = "book-demo-db"

@Database(entities = [BestSellerNameEntity::class, BestSellersEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bestSellersDao(): BestSellersDao
}
