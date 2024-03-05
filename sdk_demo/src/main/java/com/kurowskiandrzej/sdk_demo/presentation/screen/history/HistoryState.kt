package com.kurowskiandrzej.sdk_demo.presentation.screen.history

import com.kurowskiandrzej.db.CalculatorHistoryEntity

data class HistoryState(
    val calculationResults: List<CalculatorHistoryEntity> = emptyList(),
)
