package com.kurowskiandrzej.sdk_demo.data.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.kurowskiandrzej.db.CalculatorHistoryEntity
import com.kurowskiandrzej.db.SdkDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class CalculationHistoryDataSourceImpl(
    sdkDatabase: SdkDatabase,
) : CalculatorHistoryDataSource {

    private val queries = sdkDatabase.calculatorHistoryQueries

    override suspend fun insertCalculatorHistory(calculationResult: Long) {
        queries.insertCalculatorHistory(calculationResult)
    }

    override fun getCalculatorHistory(): Flow<List<CalculatorHistoryEntity>> {
        return queries.getCalculatorHistory()
            .asFlow()
            .mapToList(Dispatchers.IO)
    }
}
