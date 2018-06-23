package com.mzkii.dev.qiitamvp

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
}