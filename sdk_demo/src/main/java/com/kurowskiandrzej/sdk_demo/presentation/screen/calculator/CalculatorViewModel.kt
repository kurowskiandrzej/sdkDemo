package com.kurowskiandrzej.sdk_demo.presentation.screen.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.sdk_demo.domain.use_case.CalculateUseCase
import com.kurowskiandrzej.sdk_demo.domain.use_case.InsertCalculationResultUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculateUseCase: CalculateUseCase,
    private val insertCalculationResultUseCase: InsertCalculationResultUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.AChanged -> {
                _state.update { it.copy(aInput = event.aUpdate.removeSuffix(",")) }
            }

            is CalculatorEvent.BChanged -> {
                _state.update { it.copy(bInput = event.bUpdate.removeSuffix(",")) }
            }

            is CalculatorEvent.CalculateClicked -> {
                _state.update { state ->
                    val result = calculateUseCase(
                        a = state.aInput.toLong(),
                        b = state.bInput.toLong(),
                        operation = state.currentOperation,
                    )

                    viewModelScope.launch {
                        insertCalculationResultUseCase(result)
                    }

                    state.copy(
                        aInput = "",
                        bInput = "",
                        result = result.toString(),
                    )
                }
            }

            is CalculatorEvent.OperationChanged -> {
                _state.update { it.copy(currentOperation = event.operation) }
            }
        }
    }
}
