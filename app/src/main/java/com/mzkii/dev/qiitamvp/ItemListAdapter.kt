package com.mzkii.dev.qiitamvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mzkii.dev.qiitamvp.databinding.ListRowBinding

class ItemListAdapter constructor(private val itemList: List<Item>) : BaseAdapter() {

    override fun getItem(position: Int): Item = itemList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = itemList.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListRowBinding
        if (convertView == null) {
            binding = ListRowBinding.inflate(LayoutInflater.from(parent!!.context))
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListRowBinding
        }
        getItem(position).apply {
            binding.title.text = title
            binding.createAt.text = createdAt
        }
        return binding.root
    }
}