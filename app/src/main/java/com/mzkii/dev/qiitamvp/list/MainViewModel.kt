package com.mzkii.dev.qiitamvp.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.mzkii.dev.qiitamvp.model.Item
import com.mzkii.dev.qiitamvp.network.NetworkState
import com.mzkii.dev.qiitamvp.network.QiitaService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 10
    }

    val items: LiveData<PagedList<Item>>

    val networkState: LiveData<NetworkState>

    init {
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val qiitaService = Retrofit.Builder()
                .baseUrl("https://qiita.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(QiitaService::class.java)

        val factory = ItemDataSourceFactory(qiitaService)

        val config =
                PagedList.Config.Builder()
                        .setInitialLoadSizeHint(PAGE_SIZE)
                        .setPageSize(PAGE_SIZE)
                        .build()

        items = LivePagedListBuilder(factory, config).build()

        networkState = factory.source.networkState
    }
}