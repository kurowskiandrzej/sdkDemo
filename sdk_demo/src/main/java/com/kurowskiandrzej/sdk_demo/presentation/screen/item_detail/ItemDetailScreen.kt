package com.kurowskiandrzej.sdk_demo.presentation.screen.item_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun ItemDetailScreen() {
    val viewModel = getViewModel<ItemDetailViewModel>()
    val state by viewModel.state.collectAsState()

    ItemDetailContent(state = state)
}

@Composable
private fun ItemDetailContent(
    state: ItemDetailState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        if (state.item != null) {
            Text(text = "${state.item.id}. ${state.item.title}")

            Text(text = state.item.description)
        } else {
            Text(text = "Item not found")
        }
    }
}
