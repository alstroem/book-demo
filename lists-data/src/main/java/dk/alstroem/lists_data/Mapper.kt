package dk.alstroem.lists_data

import dk.alstroem.lists_data.remote.model.ListNameResultRemote
import dk.alstroem.lists_data.remote.model.ListNamesRemote
import dk.alstroem.lists_data.remote.model.UpdateFrequencyRemote
import dk.alstroem.lists_domain.model.ListNameResult
import dk.alstroem.lists_domain.model.ListNames
import dk.alstroem.lists_domain.model.UpdateFrequency

internal fun ListNamesRemote.mapToDomain() = ListNames(
    status, copyright, numResults, results.map { it.mapToDomain() }
)

private fun ListNameResultRemote.mapToDomain() = ListNameResult(
    listName, displayName, listNameEncoded, oldestPublishedDate,
    newestPublishedDate, updated.mapToDomain()
)

private fun UpdateFrequencyRemote.mapToDomain() = UpdateFrequency.valueOf(name)
