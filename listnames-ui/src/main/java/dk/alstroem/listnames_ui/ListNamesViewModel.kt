package dk.alstroem.listnames_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.lists_domain.GetListNamesUseCase
import dk.alstroem.lists_domain.model.ListNameResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNamesViewModel @Inject constructor(
    private val getListNamesUseCase: GetListNamesUseCase
): ViewModel() {

    private val _listNameItems = MutableLiveData<List<ListNameResult>>()
    val listNameItems: LiveData<List<ListNameResult>> = _listNameItems

    init {
        fetchListNames()
    }

    private fun fetchListNames() {
        viewModelScope.launch {
            val listNames = getListNamesUseCase()
            _listNameItems.value = listNames.results.sortedBy { it.displayName }
        }
    }
}
