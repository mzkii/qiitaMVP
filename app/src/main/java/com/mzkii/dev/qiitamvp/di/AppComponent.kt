package com.mzkii.dev.qiitamvp.di

import com.mzkii.dev.qiitamvp.list.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
}