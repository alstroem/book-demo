package dk.alstroem.book_domain

import dk.alstroem.book_domain.model.BookList
import javax.inject.Inject

class GetBookListUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(
        encodedName: String,
        date: String = "current",
        offset: Int
    ): BookList {
        return bookRepository.fetchBookList(encodedName, date, offset)
    }
}
