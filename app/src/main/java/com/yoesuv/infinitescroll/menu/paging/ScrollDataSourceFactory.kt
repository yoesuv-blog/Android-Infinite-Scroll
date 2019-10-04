package com.yoesuv.infinitescroll.menu.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yoesuv.infinitescroll.menu.models.ItemDataModel
import com.yoesuv.infinitescroll.utils.logDebug

class ScrollDataSourceFactory: DataSource.Factory<Int, ItemDataModel>() {

    var liveDataScrollDataSource: MutableLiveData<ScrollDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, ItemDataModel> {
        logDebug("ScrollDataSourceFactory # create")
        val scrollDataSource = ScrollDataSource()
        liveDataScrollDataSource.postValue(scrollDataSource)
        return scrollDataSource
    }
}