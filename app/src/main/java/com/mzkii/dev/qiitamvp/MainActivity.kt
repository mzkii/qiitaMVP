package com.mzkii.dev.qiitamvp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mzkii.dev.qiitamvp.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var service: QiitaService

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        service.fetchQiitaItems(1, 40, "Kotlin")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(items: List<Item>) {
        binding.listView.adapter = ItemListAdapter(items)
    }

    private fun handleError(error: Throwable) {
        Timber.tag("handleError").d(error)
    }
}
