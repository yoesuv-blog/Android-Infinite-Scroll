package com.yoesuv.infinitescroll.menu.paging

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.yoesuv.infinitescroll.Constants
import com.yoesuv.infinitescroll.menu.models.ItemDataModel
import com.yoesuv.infinitescroll.utils.LoadingState
import com.yoesuv.infinitescroll.utils.logDebug

class ScrollDataSource: PageKeyedDataSource<Int, ItemDataModel> () {

    var listItemDataModel:MutableList<ItemDataModel> = mutableListOf()
    var loadingState: MutableLiveData<LoadingState> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ItemDataModel>) {
        logDebug("ScrollDataSource # loadInitial")
        updateState(LoadingState.LOADING)
        listItemDataModel.clear()
        for (i:Int in 0 until 20) {
            logDebug("ScrollDataSource # loadInitial $i")
            val itemDataModel = ItemDataModel("Data ke $i")
            listItemDataModel.add(itemDataModel)
        }
        SystemClock.sleep(2000)
        updateState(LoadingState.DONE)
        callback.onResult(listItemDataModel, 0, Constants.DATA_LIMIT)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ItemDataModel>) {
        logDebug("ScrollDataSource # loadAfter")
        updateState(LoadingState.LOADING)
        listItemDataModel.clear()
        for (i:Int in 0 until 20) {
            logDebug("ScrollDataSource # loadAfter $i")
            val itemDataModel = ItemDataModel("Data ke $i")
            listItemDataModel.add(itemDataModel)
        }
        SystemClock.sleep(2000)
        updateState(LoadingState.DONE)
        callback.onResult(listItemDataModel, params.key+Constants.DATA_LIMIT)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ItemDataModel>) {

    }

    fun updateState(state: LoadingState) {
        this.loadingState.postValue(state)
    }
}