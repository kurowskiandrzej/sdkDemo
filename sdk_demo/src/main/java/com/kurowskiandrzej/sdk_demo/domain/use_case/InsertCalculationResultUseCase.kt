package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.sdk_demo.domain.repository.CalculatorHistoryRepository

class InsertCalculationResultUseCase(
    private val calculatorHistoryRepository: CalculatorHistoryRepository,
) {
    suspend operator fun invoke(calculationResult: Long) {
        calculatorHistoryRepository.insertCalculatorHistory(calculationResult)
    }
}
