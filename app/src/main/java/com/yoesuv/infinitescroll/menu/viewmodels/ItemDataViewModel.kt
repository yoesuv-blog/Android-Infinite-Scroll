package com.yoesuv.infinitescroll.menu.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.infinitescroll.menu.models.ItemDataModel

class ItemDataViewModel(itemDataModel: ItemDataModel?): ViewModel() {

    var content: ObservableField<String?> = ObservableField(itemDataModel?.content)

}