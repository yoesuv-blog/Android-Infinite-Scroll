package com.yoesuv.infinitescroll.utils

import androidx.recyclerview.widget.DiffUtil
import com.yoesuv.infinitescroll.menu.models.ItemDataModel

object AdapterCallback {

    val DIFF_CALLBACK = object: DiffUtil.ItemCallback<ItemDataModel>() {

        override fun areItemsTheSame(oldItem: ItemDataModel, newItem: ItemDataModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemDataModel, newItem: ItemDataModel): Boolean {
            return oldItem.content.equals(newItem.content)
        }

    }
}