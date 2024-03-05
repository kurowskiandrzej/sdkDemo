package com.kurowskiandrzej.sdk_demo.presentation.screen.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kurowskiandrzej.sdk_demo.presentation.UiParams
import org.koin.compose.koinInject

@Composable
fun UiParamsPreviewScreen(
    navController: NavController,
) {
    val uiParams = koinInject<UiParams>()

    UiParamsPreviewContent(
        uiParams = uiParams,
        navigateBack = { navController.popBackStack() },
    )
}

@Composable
private fun UiParamsPreviewContent(
    uiParams: UiParams,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp),
        ) {
            Text(text = "small - ${uiParams.small} sp", fontSize = uiParams.small.sp)
            Text(text = "medium - ${uiParams.medium} sp", fontSize = uiParams.medium.sp)
            Text(text = "large - ${uiParams.large} sp", fontSize = uiParams.large.sp)
        }

        Button(onClick = navigateBack) {
            Text(text = "Back")
        }
    }
}
