package dk.alstroem.lists_domain.model

data class BookList(
    val copyright: String,
    val lastModified: String,
    val numResults: Int,
    val results: BookResults,
    val status: String
)
