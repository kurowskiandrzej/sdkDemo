package com.kurowskiandrzej.sdk_demo.presentation.screen.items_list

import androidx.lifecycle.ViewModel
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetItemsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ItemsListViewModel(
    private val getItemsListUseCase: GetItemsListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ItemsListState())
    val state = _state.asStateFlow()

    init {
        _state.update { it.copy(items = getItemsListUseCase()) }
    }
}
