package com.kurowskiandrzej.sdk_demo.data.db

import com.kurowskiandrzej.db.CalculatorHistoryEntity
import kotlinx.coroutines.flow.Flow

interface CalculatorHistoryDataSource {

    suspend fun insertCalculatorHistory(calculationResult: Long)

    fun getCalculatorHistory(): Flow<List<CalculatorHistoryEntity>>
}
