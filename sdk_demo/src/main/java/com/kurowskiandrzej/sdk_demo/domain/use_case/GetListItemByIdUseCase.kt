package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.sdk_demo.domain.model.ListItem
import com.kurowskiandrzej.sdk_demo.domain.repository.ItemsListRepository

class GetListItemByIdUseCase(
    private val itemsListRepository: ItemsListRepository,
) {
    operator fun invoke(id: Long): ListItem? {
        return itemsListRepository.getItemById(id)
    }
}
