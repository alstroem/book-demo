package dk.alstroem.lists_domain.model

data class ListNames(
    val status: String,
    val copyright: String,
    val numResults: Int,
    val results: List<ListNameResult>
)
