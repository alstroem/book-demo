package dk.alstroem.best_sellers_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.best_sellers_domain.GetBestSellersUseCase
import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNamesViewModel @Inject constructor(
    private val getBestSellersUseCase: GetBestSellersUseCase
): ViewModel() {

    private val _listNames = MutableStateFlow(BestSellers())
    val bestSellers: StateFlow<BestSellers> = _listNames

    init {
        fetchListNames()
    }

    private fun fetchListNames() {
        viewModelScope.launch {
            _listNames.value = getBestSellersUseCase()
        }
    }
}
