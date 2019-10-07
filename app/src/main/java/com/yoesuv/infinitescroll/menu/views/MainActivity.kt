package com.yoesuv.infinitescroll.menu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoesuv.infinitescroll.R
import com.yoesuv.infinitescroll.databinding.ActivityMainBinding
import com.yoesuv.infinitescroll.menu.adapters.ItemDataAdapter
import com.yoesuv.infinitescroll.menu.viewmodels.MainViewModel
import com.yoesuv.infinitescroll.utils.logDebug

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var itemDataAdapter: ItemDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecycler()
        observeLiveData()
    }

    private fun setupRecycler() {
        val myLayoutManager = LinearLayoutManager(this)
        itemDataAdapter = ItemDataAdapter()
        binding.recyclerViewMain.apply {
            layoutManager = myLayoutManager
            adapter = itemDataAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.pagedListItemDataModel.observe(this, Observer {
            itemDataAdapter.submitList(it)
        })
        viewModel.getLoadingState().observe(this, Observer {
            logDebug("MainActivity # getLoadingState $it")
        })
    }
}
