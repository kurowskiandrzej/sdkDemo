package com.kurowskiandrzej.sdk_demo.presentation.screen.items_list

import com.kurowskiandrzej.sdk_demo.domain.model.ListItem

data class ItemsListState(
    val items: List<ListItem> = emptyList(),
)
