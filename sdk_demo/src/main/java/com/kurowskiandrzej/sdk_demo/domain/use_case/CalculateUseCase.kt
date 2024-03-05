package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.sdk_demo.presentation.screen.calculator.CalculatorOperation

class CalculateUseCase {

    operator fun invoke(
        a: Long,
        b: Long,
        operation: CalculatorOperation,
    ): Long {

        val strategy = when (operation) {
            CalculatorOperation.ADD -> {
                CalculateStrategy.AddStrategy(a, b)
            }
            CalculatorOperation.SUBTRACT -> {
                CalculateStrategy.SubtractStrategy(a, b)
            }
        }

        return strategy.execute()
    }
}

sealed interface CalculateStrategy {

    fun execute(): Long

    data class AddStrategy(val a: Long, val b: Long) : CalculateStrategy {
        override fun execute(): Long = this.a + this.b
    }

    data class SubtractStrategy(val a: Long, val b: Long) : CalculateStrategy {
        override fun execute(): Long = a - b
    }
}
