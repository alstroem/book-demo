package dk.alstroem.book_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResultsRemote(
    @SerialName("bestsellers_date")
    val bestsellersDate: String,
    @SerialName("books")
    val books: List<BookRemote>,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("list_name")
    val listName: String,
    @SerialName("list_name_encoded")
    val listNameEncoded: String,
    @SerialName("next_published_date")
    val nextPublishedDate: String,
    @SerialName("normal_list_ends_at")
    val normalListEndsAt: Int,
    @SerialName("previous_published_date")
    val previousPublishedDate: String,
    @SerialName("published_date")
    val publishedDate: String,
    @SerialName("published_date_description")
    val publishedDateDescription: String,
    @SerialName("updated")
    val updated: String
)
