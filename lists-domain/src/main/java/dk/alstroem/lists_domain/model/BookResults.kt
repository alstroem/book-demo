package dk.alstroem.lists_domain.model

data class BookResults(
    val bestsellersDate: String,
    val books: List<Book>,
    val displayName: String,
    val listName: String,
    val listNameEncoded: String,
    val nextPublishedDate: String,
    val normalListEndsAt: Int,
    val previousPublishedDate: String,
    val publishedDate: String,
    val publishedDateDescription: String,
    val updated: String
)
