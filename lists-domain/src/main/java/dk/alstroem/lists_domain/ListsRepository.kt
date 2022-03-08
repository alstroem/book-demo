package dk.alstroem.lists_domain

import dk.alstroem.lists_domain.model.ListNames

interface ListsRepository {
    suspend fun fetchListNames(): ListNames
}
