package com.kurowskiandrzej.sdk_demo.presentation.screen.items_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kurowskiandrzej.sdk_demo.presentation.nav.Route
import org.koin.androidx.compose.getViewModel

@Composable
fun ItemsListScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<ItemsListViewModel>()
    val state by viewModel.state.collectAsState()

    ItemsListContent(
        state = state,
        onItemClick = { id -> navController.navigate(Route.ITEM_DETAIL + "/$id") }
    )
}

@Composable
private fun ItemsListContent(
    state: ItemsListState,
    onItemClick: (Long) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            items(state.items.count()) { position ->
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onItemClick(state.items[position].id) }
                ) {
                    Text(text = "${state.items[position].id}. ${state.items[position].title}")
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = state.items[position].description)
                }
            }
        }
    }
}
