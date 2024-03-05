package com.kurowskiandrzej.sdk_demo.presentation.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetCalculatorHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val getCalculatorHistoryUseCase: GetCalculatorHistoryUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HistoryState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCalculatorHistoryUseCase().collect {
                _state.update { state -> state.copy(calculationResults = it) }
            }
        }
    }
}
