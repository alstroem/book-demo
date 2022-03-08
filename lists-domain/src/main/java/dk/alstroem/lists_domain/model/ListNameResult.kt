package dk.alstroem.lists_domain.model

data class ListNameResult(
    val listName: String,
    val displayName: String,
    val listNameEncoded: String,
    val oldestPublishedDate: String,
    val newestPublishedDate: String,
    val updated: UpdateFrequency
)
