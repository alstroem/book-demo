package dk.alstroem.listnames_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.lists_domain.GetListNamesUseCase
import dk.alstroem.lists_domain.model.ListNameResult
import dk.alstroem.lists_domain.model.ListNames
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNamesViewModel @Inject constructor(
    private val getListNamesUseCase: GetListNamesUseCase
): ViewModel() {

    private val _listNames = MutableLiveData<List<ListNameResult>>()
    val listNames: LiveData<List<ListNameResult>> = _listNames

    init {
        fetchListNames()
    }

    private fun fetchListNames() {
        viewModelScope.launch {
            _listNames.value = getListNamesUseCase().results
        }
    }
}
