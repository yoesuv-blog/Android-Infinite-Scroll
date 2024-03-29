package com.yoesuv.infinitescroll.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.infinitescroll.R
import com.yoesuv.infinitescroll.databinding.ItemDataBinding
import com.yoesuv.infinitescroll.databinding.ItemLoadMoreBinding
import com.yoesuv.infinitescroll.menu.models.ItemDataModel
import com.yoesuv.infinitescroll.menu.viewmodels.ItemDataViewModel
import com.yoesuv.infinitescroll.utils.AdapterCallback
import com.yoesuv.infinitescroll.utils.LoadingState

class ItemDataAdapter: PagedListAdapter<ItemDataModel, RecyclerView.ViewHolder>(AdapterCallback.DIFF_CALLBACK) {

    companion object {
        const val VIEW_TYPE_ITEM = 1
        const val VIEW_TYPE_LOADING = 2
    }

    private var loadingState: LoadingState = LoadingState.LOADING

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) VIEW_TYPE_ITEM else VIEW_TYPE_LOADING
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == VIEW_TYPE_ITEM) {
            val binding: ItemDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_data, parent, false)
            return ItemDataViewHolder(binding)
        } else {
            val binding: ItemLoadMoreBinding = DataBindingUtil.inflate(inflater, R.layout.item_load_more, parent, false)
            return LoadMoreViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemDataViewHolder) {
            val itemDataModel = getItem(holder.adapterPosition)
            holder.bindData(itemDataModel)
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && loadingState == LoadingState.LOADING
    }

    class ItemDataViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(itemDataModel: ItemDataModel?) {
            binding.itemData = ItemDataViewModel(itemDataModel)
            binding.executePendingBindings()
        }

    }

    class LoadMoreViewHolder(binding: ItemLoadMoreBinding) : RecyclerView.ViewHolder(binding.root)

}