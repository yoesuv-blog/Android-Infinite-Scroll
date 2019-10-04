package com.yoesuv.infinitescroll.menu.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yoesuv.infinitescroll.Constants
import com.yoesuv.infinitescroll.menu.models.ItemDataModel
import com.yoesuv.infinitescroll.menu.paging.ScrollDataSourceFactory

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var scrollDataSourceFactory: ScrollDataSourceFactory = ScrollDataSourceFactory()
    var pagedListItemDataModel: LiveData<PagedList<ItemDataModel>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(Constants.DATA_LIMIT)
            .setPrefetchDistance(5)
            .setInitialLoadSizeHint(Constants.DATA_LIMIT)
            .setEnablePlaceholders(false)
            .build()
        pagedListItemDataModel = LivePagedListBuilder(scrollDataSourceFactory, config).build()
    }
}