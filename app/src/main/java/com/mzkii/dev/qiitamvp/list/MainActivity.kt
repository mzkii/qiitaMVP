package com.mzkii.dev.qiitamvp.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.mzkii.dev.qiitamvp.R
import com.mzkii.dev.qiitamvp.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val adapter = ItemAdapter()
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recycler.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.items.observe(this, Observer { pagedList ->
            Timber.d("Receive Result")
            adapter.submitList(pagedList)
        })

        viewModel.networkState.observe(this, Observer { networkState ->
            Timber.d("NetworkState: $networkState")
        })
    }
}
