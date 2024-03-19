package com.kurowskiandrzej.sdk_demo.domain.repository

import com.kurowskiandrzej.sdk_demo.domain.model.ListItem

interface ItemsListRepository {

    fun getItems(): List<ListItem>

    fun getItemById(id: Long): ListItem?
}
