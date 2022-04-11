package dk.alstroem.best_sellers_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dk.alstroem.best_sellers_data.local.model.BestSellerNameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BestSellersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBestSellerNames(bestSellerNames: List<BestSellerNameEntity>)

    @Query("SELECT * FROM BestSellerName")
    fun getAllBestSellerNames(): Flow<List<BestSellerNameEntity>>

}
