package dk.alstroem.best_sellers_data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BestSellerName")
data class BestSellerNameEntity(
    val listName: String,
    val displayName: String,
    @PrimaryKey val listNameEncoded: String,
    val oldestPublishedDate: String,
    val newestPublishedDate: String,
    val updated: UpdateFrequencyEntity
)
