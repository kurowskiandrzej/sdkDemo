package com.kurowskiandrzej.sdk_demo.presentation.screen.calculator

sealed interface CalculatorEvent {

    data class AChanged(val aUpdate: String) : CalculatorEvent

    data class BChanged(val bUpdate: String) : CalculatorEvent

    data object CalculateClicked : CalculatorEvent

    data class OperationChanged(val operation: CalculatorOperation) : CalculatorEvent
}
