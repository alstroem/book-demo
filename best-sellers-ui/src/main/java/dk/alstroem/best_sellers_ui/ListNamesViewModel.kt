package dk.alstroem.best_sellers_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.best_sellers_domain.GetListNamesUseCase
import dk.alstroem.best_sellers_domain.model.ListNames
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNamesViewModel @Inject constructor(
    private val getListNamesUseCase: GetListNamesUseCase
): ViewModel() {

    private val _listNames = MutableStateFlow(ListNames())
    val listNames: StateFlow<ListNames> = _listNames

    init {
        fetchListNames()
    }

    private fun fetchListNames() {
        viewModelScope.launch {
            _listNames.value = getListNamesUseCase()
        }
    }
}
