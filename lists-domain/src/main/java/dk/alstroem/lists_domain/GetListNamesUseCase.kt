package dk.alstroem.lists_domain

import dk.alstroem.lists_domain.model.ListNames

class GetListNamesUseCase(
    private val repository: ListsRepository
) {
    suspend operator fun invoke(): ListNames {
        return repository.fetchListNames()
    }
}
