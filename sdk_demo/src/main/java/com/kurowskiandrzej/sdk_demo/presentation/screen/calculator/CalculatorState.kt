package com.kurowskiandrzej.sdk_demo.presentation.screen.calculator

data class CalculatorState(
    val aInput: String = "",
    val bInput: String = "",
    val result: String = "",
    val currentOperation: CalculatorOperation = CalculatorOperation.ADD,
)
