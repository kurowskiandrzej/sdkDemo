package com.kurowskiandrzej.sdk_demo.presentation.screen.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kurowskiandrzej.sdk_demo.presentation.nav.Route
import org.koin.androidx.compose.getViewModel

@Composable
fun CalculatorScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<CalculatorViewModel>()
    val state by viewModel.state.collectAsState()

    CalculatorContent(
        state = state,
        onEvent = viewModel::onEvent,
        navigateToHistory = { navController.navigate(Route.HISTORY) },
        navigateToUiParamsPreview = { navController.navigate(Route.UI_PARAMS_PREVIEW) },
        navigateToItemsList = { navController.navigate(Route.ITEMS_LIST) },
    )
}

@Composable
private fun CalculatorContent(
    state: CalculatorState,
    onEvent: (CalculatorEvent) -> Unit,
    navigateToHistory: () -> Unit,
    navigateToUiParamsPreview: () -> Unit,
    navigateToItemsList: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        TextField(
            value = state.aInput,
            onValueChange = { onEvent(CalculatorEvent.AChanged(it)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal),
        )
        TextField(
            value = state.bInput,
            onValueChange = { onEvent(CalculatorEvent.BChanged(it)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal),
        )

        Column(
            modifier = Modifier
                .padding(vertical = 10.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = state.currentOperation == CalculatorOperation.ADD,
                    onClick = { onEvent(CalculatorEvent.OperationChanged(CalculatorOperation.ADD)) }
                )
                Text(text = "Add")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = state.currentOperation == CalculatorOperation.SUBTRACT,
                    onClick = { onEvent(CalculatorEvent.OperationChanged(CalculatorOperation.SUBTRACT)) }
                )
                Text(text = "Subtract")
            }
        }

        Text(text = "Result:")
        Text(text = state.result)
        Button(
            onClick = { onEvent(CalculatorEvent.CalculateClicked) },
            enabled = state.aInput.isNotBlank() && state.bInput.isNotBlank(),
        ) {
            Text(text = "Calculate")
        }

        Button(onClick = navigateToHistory) {
            Text(text = "History")
        }
        Button(onClick = navigateToUiParamsPreview) {
            Text(text = "Ui Params Preview")
        }
        Button(onClick = navigateToItemsList) {
            Text(text = "Items List")
        }
    }
}
