package com.kurowskiandrzej.sdk_demo.domain.repository

import com.kurowskiandrzej.db.CalculatorHistoryEntity
import kotlinx.coroutines.flow.Flow

interface CalculatorHistoryRepository {

    suspend fun insertCalculatorHistory(calculationResult: Long)

    fun getCalculatorHistory(): Flow<List<CalculatorHistoryEntity>>
}
