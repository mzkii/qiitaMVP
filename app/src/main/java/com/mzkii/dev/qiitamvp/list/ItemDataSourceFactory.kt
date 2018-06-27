package com.mzkii.dev.qiitamvp.list

import android.arch.paging.DataSource
import com.mzkii.dev.qiitamvp.model.Item
import com.mzkii.dev.qiitamvp.network.QiitaService

class ItemDataSourceFactory(qiitaService: QiitaService) : DataSource.Factory<Int, Item>() {

    val source = PageKeyedItemDataSource(qiitaService)

    override fun create(): DataSource<Int, Item> {
        return source
    }
}