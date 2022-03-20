package dk.alstroem.lists_data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.alstroem.lists_data.remote.ListsRemoteDataSource
import dk.alstroem.lists_data.remote.model.BookRemote
import java.io.IOException
import java.lang.Exception

private const val PAGE_SIZE = 20

class BookPagingSource(
    private val remoteDataSource: ListsRemoteDataSource,
    private val query: String
) : PagingSource<Int, BookRemote>() {

    override fun getRefreshKey(state: PagingState<Int, BookRemote>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BookRemote> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getBookList(
                encodedName = query,
                offset = pageNumber.times(PAGE_SIZE)
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
