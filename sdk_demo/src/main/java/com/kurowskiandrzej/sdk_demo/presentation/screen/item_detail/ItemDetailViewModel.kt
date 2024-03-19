package com.kurowskiandrzej.sdk_demo.presentation.screen.item_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetListItemByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ItemDetailViewModel(
    savedStateHandle: SavedStateHandle,
    getListItemByIdUseCase: GetListItemByIdUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(
        ItemDetailState(getListItemByIdUseCase(savedStateHandle.get<Long>("itemId")!!))
    )
    val state = _state.asStateFlow()
}
