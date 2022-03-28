package dk.alstroem.book_data

import dk.alstroem.book_data.remote.model.BookListRemote
import dk.alstroem.book_data.remote.model.BookRemote
import dk.alstroem.book_data.remote.model.BookResultsRemote
import dk.alstroem.book_data.remote.model.BuyLinkRemote
import dk.alstroem.book_data.remote.model.IsbnRemote
import dk.alstroem.book_domain.model.Book
import dk.alstroem.book_domain.model.BookList
import dk.alstroem.book_domain.model.BookResults
import dk.alstroem.book_domain.model.BuyLink
import dk.alstroem.book_domain.model.Isbn

internal fun BookListRemote.mapToDomain(): BookList {
    return BookList(
        copyright,
        lastModified,
        numResults,
        results.mapToDomain(),
        status
    )
}

private fun BookResultsRemote.mapToDomain(): BookResults {
    return BookResults(
        bestsellersDate, books.map { it.mapToDomain() }, displayName, listName,
        listNameEncoded, nextPublishedDate, normalListEndsAt, previousPublishedDate, publishedDate,
        publishedDateDescription, updated
    )
}

private fun BookRemote.mapToDomain(): Book {
    return Book(
        ageGroup,
        amazonProductUrl,
        articleChapterLink,
        asterisk,
        author,
        bookImage,
        bookImageHeight,
        bookImageWidth,
        bookReviewLink,
        bookUri,
        buyLinks.map { it.mapToDomain() },
        contributor,
        contributorNote,
        dagger,
        description,
        firstChapterLink,
        isbns.map { it.mapToDomain() },
        price,
        primaryIsbn10,
        primaryIsbn13,
        publisher,
        rank,
        rankLastWeek,
        sundayReviewLink,
        title,
        weeksOnList
    )
}

private fun BuyLinkRemote.mapToDomain(): BuyLink {
    return BuyLink(name, url)
}

private fun IsbnRemote.mapToDomain(): Isbn {
    return Isbn(isbn10, isbn13)
}
