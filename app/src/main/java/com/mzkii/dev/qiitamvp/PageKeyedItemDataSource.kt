package com.mzkii.dev.qiitamvp

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class PageKeyedItemDataSource(private val qiitaService: QiitaService) : PageKeyedDataSource<Int, Item>() {

    val networkState = MutableLiveData<NetworkState>()

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        callAPI(params.key, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, next)
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        callAPI(1, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, null, next)
        }
    }

    private fun callAPI(page: Int, perPage: Int, callBack: (repos: List<Item>, next: Int?) -> Unit) {
        networkState.postValue(NetworkState.RUNNING)
        var state = NetworkState.FAILED
        qiitaService
                .fetchQiitaItems(page, perPage, "Kotlin")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        //TODO 最後のページか確認
                        { callBack(it, page + 1) },
                        { Timber.w(it) })
        networkState.postValue(state)
    }
}