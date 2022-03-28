package dk.alstroem.best_sellers_data

import dk.alstroem.best_sellers_data.remote.model.ListNameResultRemote
import dk.alstroem.best_sellers_data.remote.model.ListNamesRemote
import dk.alstroem.best_sellers_data.remote.model.UpdateFrequencyRemote
import dk.alstroem.best_sellers_domain.model.ListNameResult
import dk.alstroem.best_sellers_domain.model.ListNames
import dk.alstroem.best_sellers_domain.model.UpdateFrequency

internal fun ListNamesRemote.mapToDomain() = ListNames(
    status, copyright, numResults, results.map { it.mapToDomain() }
)

private fun ListNameResultRemote.mapToDomain() = ListNameResult(
    listName, displayName, listNameEncoded, oldestPublishedDate,
    newestPublishedDate, updated.mapToDomain()
)

private fun UpdateFrequencyRemote.mapToDomain() = UpdateFrequency.valueOf(name)
