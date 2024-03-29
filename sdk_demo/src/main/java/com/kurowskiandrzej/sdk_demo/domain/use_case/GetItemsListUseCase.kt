package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.sdk_demo.domain.model.ListItem
import com.kurowskiandrzej.sdk_demo.domain.repository.ItemsListRepository

class GetItemsListUseCase(
    private val itemsListRepository: ItemsListRepository,
) {
    operator fun invoke(): List<ListItem> {
        return itemsListRepository.getItems()
    }
}
