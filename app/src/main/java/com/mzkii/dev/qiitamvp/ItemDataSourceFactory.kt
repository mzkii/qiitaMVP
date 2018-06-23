package com.mzkii.dev.qiitamvp

import android.arch.paging.DataSource

class ItemDataSourceFactory(qiitaService: QiitaService) : DataSource.Factory<Int, Item>() {

    val source = PageKeyedItemDataSource(qiitaService)

    override fun create(): DataSource<Int, Item> {
        return source
    }
}