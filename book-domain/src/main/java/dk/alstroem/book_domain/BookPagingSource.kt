package dk.alstroem.book_domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.alstroem.book_domain.model.Book
import java.io.IOException

class BookPagingSource(
    private val getBookList: GetBookListUseCase,
    private val query: String
) : PagingSource<Int, Book>() {

    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        return try {
            val pageNumber = params.key ?: 0
            val offset = pageNumber.times(params.loadSize)
            val response = getBookList(
                encodedName = query,
                offset = offset
            )

            val nextPageNumber = (pageNumber + 1).takeIf { it.times(params.loadSize) < response.numResults }
            LoadResult.Page(
                data = response.results.books,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}