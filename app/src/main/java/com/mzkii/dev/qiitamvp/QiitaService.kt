package com.mzkii.dev.qiitamvp

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaService {
    @GET("api/v2/items")
    fun fetchQiitaItems(@Query("page") page: Int,
                        @Query("per_page") perPage: Int,
                        @Query("query") query: String): Single<List<Item>>
}