package dk.alstroem.best_sellers_data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BestSellers")
data class BestSellersEntity(
    @PrimaryKey val status: String,
    val copyright: String,
    val numResults: Int
)
