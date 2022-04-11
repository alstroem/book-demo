package dk.alstroem.best_sellers_domain.model

data class BestSellers(
    val status: String = "",
    val copyright: String = "",
    val numResults: Int = 0,
    val results: List<BestSellerName> = emptyList()
)
