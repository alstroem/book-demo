package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.local.model.BestSellerNameEntity
import dk.alstroem.best_sellers_data.local.model.UpdateFrequencyEntity
import dk.alstroem.best_sellers_data.remote.model.BestSellerNameRemote
import dk.alstroem.best_sellers_data.remote.model.BestSellersRemote
import dk.alstroem.best_sellers_data.remote.model.UpdateFrequencyRemote
import dk.alstroem.best_sellers_domain.model.BestSellerName
import dk.alstroem.best_sellers_domain.model.BestSellers
import dk.alstroem.best_sellers_domain.model.UpdateFrequency

internal fun BestSellersRemote.mapToDomain() = BestSellers(
    status, copyright, numResults, results.map { it.mapToDomain() }
)

private fun BestSellerNameRemote.mapToDomain() = BestSellerName(
    listName, displayName, listNameEncoded, oldestPublishedDate,
    newestPublishedDate, updated.mapToDomain()
)

private fun UpdateFrequencyRemote.mapToDomain() = UpdateFrequency.valueOf(name)

internal fun BestSellerNameRemote.mapToEntity() = BestSellerNameEntity(
    listName, displayName, listNameEncoded, oldestPublishedDate, newestPublishedDate, updated.mapToEntity()
)

private fun UpdateFrequencyRemote.mapToEntity() = UpdateFrequencyEntity.valueOf(name)
