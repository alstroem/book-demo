package dk.alstroem.best_sellers_data.local

import androidx.room.TypeConverter
import dk.alstroem.best_sellers_data.local.model.UpdateFrequencyEntity

class Converters {

    @TypeConverter
    fun toUpdateFrequency(value: String) = enumValueOf<UpdateFrequencyEntity>(value)

    @TypeConverter
    fun fromUpdateFrequency(value: UpdateFrequencyEntity) = value.name
}
