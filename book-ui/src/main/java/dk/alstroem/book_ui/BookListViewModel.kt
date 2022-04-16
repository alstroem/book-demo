package dk.alstroem.book_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.book_domain.BookPagingSource
import dk.alstroem.book_domain.GetBookListUseCase
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getBookList: GetBookListUseCase
) : ViewModel() {

    fun getPageFlow(encodedName: String) = Pager(
        PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            enablePlaceholders = false
        )
    ) {
        BookPagingSource(getBookList, encodedName)
    }.flow.cachedIn(viewModelScope)
}
