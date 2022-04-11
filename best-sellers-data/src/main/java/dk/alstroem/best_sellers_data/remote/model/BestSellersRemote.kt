package dk.alstroem.best_sellers_data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BestSellersRemote(
    @SerialName("status")
    val status: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val results: List<BestSellerNameRemote>
)
