package com.yoesuv.infinitescroll.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.infinitescroll.R
import com.yoesuv.infinitescroll.databinding.ItemDataBinding
import com.yoesuv.infinitescroll.databinding.ItemLoadMoreBinding
import com.yoesuv.infinitescroll.menu.models.ItemDataModel
import com.yoesuv.infinitescroll.menu.viewmodels.ItemDataViewModel
import com.yoesuv.infinitescroll.utils.AdapterCallback

class ItemDataAdapter: ListAdapter<ItemDataModel, RecyclerView.ViewHolder>(AdapterCallback.DIFF_CALLBACK) {

    companion object {
        const val VIEW_TYPE_LOADING = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val binding: ItemDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_data, parent, false)
            return ItemDataViewHolder(binding)
        } else {
            val binding: ItemLoadMoreBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_load_more, parent, false)
            return LoadMoreViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemDataViewHolder) {
            val itemDataModel = getItem(holder.adapterPosition)
            holder.bindData(itemDataModel)
        }
    }

    class ItemDataViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(itemDataModel: ItemDataModel) {
            binding.itemData = ItemDataViewModel(itemDataModel)
            binding.executePendingBindings()
        }

    }

    class LoadMoreViewHolder(binding: ItemLoadMoreBinding) : RecyclerView.ViewHolder(binding.root)

}