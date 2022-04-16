package dk.alstroem.best_sellers_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.alstroem.best_sellers_domain.GetBestSellerNamesUseCase
import dk.alstroem.best_sellers_domain.GetBestSellersUseCase
import dk.alstroem.best_sellers_domain.UpdateBestSellersUseCase
import dk.alstroem.best_sellers_domain.model.BestSellerName
import dk.alstroem.best_sellers_domain.model.BestSellers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListNamesViewModel @Inject constructor(
    private val updateBestSellers: UpdateBestSellersUseCase,
    getBestSellers: GetBestSellersUseCase,
    getBestSellerNames: GetBestSellerNamesUseCase
): ViewModel() {

    val bestSellers = getBestSellers().asLiveData()
    val bestSellerNames = getBestSellerNames().asLiveData()

    init {
        fetchListNames()
    }

    private fun fetchListNames() {
        viewModelScope.launch {
            updateBestSellers()
        }
    }
}
