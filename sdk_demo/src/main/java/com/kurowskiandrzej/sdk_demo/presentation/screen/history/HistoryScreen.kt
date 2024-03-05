package com.kurowskiandrzej.sdk_demo.presentation.screen.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun HistoryScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<HistoryViewModel>()
    val state by viewModel.state.collectAsState()

    HistoryContent(
        state = state,
        navigateBack = { navController.popBackStack() },
    )
}

@Composable
private fun HistoryContent(
    state: HistoryState,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(state.calculationResults.count()) { position ->
                val item = state.calculationResults[position]

                Row {
                    Text(text = item.id.toString())
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "result = " + item.calculationResult.toString())
                }
            }
        }
        Button(onClick = navigateBack) {
            Text(text = "Back")
        }
    }
}
