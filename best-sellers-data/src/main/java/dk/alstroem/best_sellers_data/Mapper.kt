package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.local.model.BestSellerNameEntity
import dk.alstroem.best_sellers_data.local.model.BestSellersEntity
import dk.alstroem.best_sellers_data.local.model.UpdateFrequencyEntity
import dk.alstroem.best_sellers_data.remote.model.BestSellerNameRemote
import dk.alstroem.best_sellers_data.remote.model.BestSellersRemote
import dk.alstroem.best_sellers_data.remote.model.UpdateFrequencyRemote
import dk.alstroem.best_sellers_domain.model.BestSellerName
import dk.alstroem.best_sellers_domain.model.BestSellers
import dk.alstroem.best_sellers_domain.model.UpdateFrequency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal fun BestSellersRemote.mapToEntity() = BestSellersEntity(
    status, copyright, numResults
)

internal fun BestSellersEntity.mapToDomain() = BestSellers(
    status, copyright, numResults
)

internal fun BestSellerNameRemote.mapToEntity() = BestSellerNameEntity(
    listName, displayName, listNameEncoded, oldestPublishedDate, newestPublishedDate, updated.mapToEntity()
)

private fun UpdateFrequencyRemote.mapToEntity() = UpdateFrequencyEntity.valueOf(name)

internal fun List<BestSellerNameEntity>.mapToDomain() = map { bestSellerNameEntity ->
    bestSellerNameEntity.mapToDomain()
}

private fun BestSellerNameEntity.mapToDomain() = BestSellerName(
    listName, displayName, listNameEncoded, oldestPublishedDate, newestPublishedDate, updated.mapToDomain()
)

private fun UpdateFrequencyEntity.mapToDomain() = UpdateFrequency.valueOf(name)
