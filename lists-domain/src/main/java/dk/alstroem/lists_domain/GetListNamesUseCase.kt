package dk.alstroem.lists_domain

import dk.alstroem.lists_domain.model.ListNames
import javax.inject.Inject

class GetListNamesUseCase @Inject constructor(
    private val repository: ListsRepository
) {
    suspend operator fun invoke(): ListNames {
        return repository.fetchListNames()
    }
}
