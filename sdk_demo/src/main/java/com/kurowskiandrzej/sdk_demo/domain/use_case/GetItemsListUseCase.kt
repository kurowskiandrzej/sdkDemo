package com.kurowskiandrzej.sdk_demo.domain.use_case

import com.kurowskiandrzej.sdk_demo.domain.model.ListItem

class GetItemsListUseCase {
    operator fun invoke(): List<ListItem> {
        return listOf(
            ListItem(
                id = 1,
                title = "title 1",
                description = "description 1",
            ),
            ListItem(
                id = 2,
                title = "title 2",
                description = "description 2",
            ),
            ListItem(
                id = 3,
                title = "title 3",
                description = "description 3",
            ),
            ListItem(
                id = 4,
                title = "title 4",
                description = "description 4",
            ),
            ListItem(
                id = 5,
                title = "title 5",
                description = "description 5",
            ),
        )
    }
}
