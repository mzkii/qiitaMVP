package com.mzkii.dev.qiitamvp

import io.reactivex.Flowable

interface ItemRepository {
    fun getItemsByQuery(query: Flowable<String>): Flowable<List<Item>>
}