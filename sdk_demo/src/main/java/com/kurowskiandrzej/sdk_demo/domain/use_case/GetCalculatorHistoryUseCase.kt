package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.db.CalculatorHistoryEntity
import com.kurowskiandrzej.sdk_demo.domain.repository.CalculatorHistoryRepository
import kotlinx.coroutines.flow.Flow

class GetCalculatorHistoryUseCase(
    private val calculatorHistoryRepository: CalculatorHistoryRepository,
) {
    operator fun invoke(): Flow<List<CalculatorHistoryEntity>> {
        return calculatorHistoryRepository.getCalculatorHistory()
    }
}
