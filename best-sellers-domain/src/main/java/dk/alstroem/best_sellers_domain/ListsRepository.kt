package dk.alstroem.best_sellers_domain

import dk.alstroem.best_sellers_domain.model.ListNames

interface ListsRepository {
    suspend fun fetchListNames(): ListNames
}
