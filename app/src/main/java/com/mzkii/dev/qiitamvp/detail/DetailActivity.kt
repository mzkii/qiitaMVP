package com.mzkii.dev.qiitamvp.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mzkii.dev.qiitamvp.R
import com.mzkii.dev.qiitamvp.databinding.ActivityDetailBinding
import com.mzkii.dev.qiitamvp.model.Item

class DetailActivity : AppCompatActivity() {

    private val item: Item by lazy {
        intent.getSerializableExtra(EXTRA_ITEM) as Item
    }

    private val binding: ActivityDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding.markdown.loadMarkdown(item.body)
    }

    companion object {
        private const val EXTRA_ITEM = "ITEM"
        @JvmStatic
        fun createIntent(context: Context, item: Item): Intent =
                Intent(context, DetailActivity::class.java).putExtra(EXTRA_ITEM, item)
    }
}
