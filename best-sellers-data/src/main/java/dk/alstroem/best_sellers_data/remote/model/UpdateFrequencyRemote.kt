package dk.alstroem.best_sellers_data.remote.model

import kotlinx.serialization.Serializable

@Serializable
enum class UpdateFrequencyRemote {
    WEEKLY,
    MONTHLY
}
