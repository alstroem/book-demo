package dk.alstroem.best_sellers_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListNameResultRemote(
    @SerialName("list_name")
    val listName: String,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("list_name_encoded")
    val listNameEncoded: String,
    @SerialName("oldest_published_date")
    val oldestPublishedDate: String,
    @SerialName("newest_published_date")
    val newestPublishedDate: String,
    @SerialName("updated")
    val updated: UpdateFrequencyRemote
)
