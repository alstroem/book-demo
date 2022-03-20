package dk.alstroem.listnames_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.lists_domain.BookPagingSource
import dk.alstroem.lists_domain.GetBookListUseCase
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    encodedName: String,
    getBookList: GetBookListUseCase
): ViewModel() {

    val pageFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        BookPagingSource(getBookList, encodedName)
    }.flow.cachedIn(viewModelScope)
}
