package dk.alstroem.best_sellers_domain.model

data class BestSellerName(
    val listName: String,
    val displayName: String,
    val listNameEncoded: String,
    val oldestPublishedDate: String,
    val newestPublishedDate: String,
    val updated: UpdateFrequency
)
