package dk.alstroem.lists_data.remote.model

import kotlinx.serialization.Serializable

@Serializable
enum class UpdateFrequencyRemote {
    WEEKLY,
    MONTHLY
}
