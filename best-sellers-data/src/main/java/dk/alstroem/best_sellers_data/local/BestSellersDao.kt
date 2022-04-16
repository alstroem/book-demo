package dk.alstroem.best_sellers_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import dk.alstroem.best_sellers_data.local.model.BestSellerNameEntity
import dk.alstroem.best_sellers_data.local.model.BestSellersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BestSellersDao {

    @Transaction
    fun updateBestSellers(
        bestSellers: BestSellersEntity,
        bestSellerNames: List<BestSellerNameEntity>
    ) {
        insertBestSellers(bestSellers)
        insertAllBestSellerNames(bestSellerNames)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBestSellers(bestSellers: BestSellersEntity)

    @Query("SELECT * FROM BestSellers LIMIT 1")
    fun getBestSellers(): Flow<BestSellersEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBestSellerNames(bestSellerNames: List<BestSellerNameEntity>)

    @Query("SELECT * FROM BestSellerName")
    fun getAllBestSellerNames(): Flow<List<BestSellerNameEntity>>
}
