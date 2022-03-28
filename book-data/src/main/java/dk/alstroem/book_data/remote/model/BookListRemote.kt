package dk.alstroem.book_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookListRemote(
    @SerialName("copyright")
    val copyright: String,
    @SerialName("last_modified")
    val lastModified: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val results: BookResultsRemote,
    @SerialName("status")
    val status: String
)
