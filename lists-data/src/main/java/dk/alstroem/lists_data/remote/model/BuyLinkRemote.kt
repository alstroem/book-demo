package dk.alstroem.lists_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuyLinkRemote(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)