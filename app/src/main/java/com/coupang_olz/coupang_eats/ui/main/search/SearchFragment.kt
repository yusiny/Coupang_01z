package com.coupang_olz.coupang_eats.ui.main.search

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.data.local.Menu
import com.coupang_olz.coupang_eats.databinding.FragmentSearchBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment

class SearchFragment() : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    override fun initAfterBinding() {
        val menuRVAdpater = SearchRVAdpater()
        binding.searchRv.adapter = menuRVAdpater
        binding.searchRv.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)

        val menu = Menu("치킨", R.drawable.menu_exp)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
        menuRVAdpater.addMenu(menu)
    }
}