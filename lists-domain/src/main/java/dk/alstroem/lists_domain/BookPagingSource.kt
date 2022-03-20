package dk.alstroem.lists_domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.alstroem.lists_domain.model.Book
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
            val pageNumber = params.key ?: 1
            val response = getBookList(
                encodedName = query,
                offset = pageNumber.times(params.loadSize)
            )
            LoadResult.Page(
                data = response.results.books,
                prevKey = null,
                nextKey = pageNumber + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}
