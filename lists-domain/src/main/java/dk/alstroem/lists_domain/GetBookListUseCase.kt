package dk.alstroem.lists_domain

import dk.alstroem.lists_domain.model.BookList

class GetBookListUseCase(
    private val listsRepository: ListsRepository
) {
    suspend operator fun invoke(
        encodedName: String,
        date: String = "current",
        offset: Int
    ): BookList {
        return listsRepository.fetchBookList(encodedName, date, offset)
    }
}
