package com.kurowskiandrzej.sdk_demo.data.repository

import com.kurowskiandrzej.db.CalculatorHistoryEntity
import com.kurowskiandrzej.sdk_demo.data.db.CalculatorHistoryDataSource
import com.kurowskiandrzej.sdk_demo.domain.repository.CalculatorHistoryRepository
import kotlinx.coroutines.flow.Flow

class CalculatorHistoryRepositoryImpl(
    private val calculatorHistoryDataSource: CalculatorHistoryDataSource,
) : CalculatorHistoryRepository {

    override suspend fun insertCalculatorHistory(calculationResult: Long) {
        calculatorHistoryDataSource.insertCalculatorHistory(calculationResult)
    }

    override fun getCalculatorHistory(): Flow<List<CalculatorHistoryEntity>> {
        return calculatorHistoryDataSource.getCalculatorHistory()
    }
}
