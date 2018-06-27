package com.mzkii.dev.qiitamvp.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.mzkii.dev.qiitamvp.network.QiitaService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    private val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Singleton
    @Provides
    fun provideQiitaService(): QiitaService =
            Retrofit.Builder()
                    .baseUrl("https://qiita.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(QiitaService::class.java)
}