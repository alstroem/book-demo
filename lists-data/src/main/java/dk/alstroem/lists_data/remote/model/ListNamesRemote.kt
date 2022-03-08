package dk.alstroem.lists_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListNamesRemote(
    @SerialName("status")
    val status: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val results: List<ListNameResultRemote>
)
