package dk.alstroem.lists_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IsbnRemote(
    @SerialName("isbn10")
    val isbn10: String,
    @SerialName("isbn13")
    val isbn13: String
)
