package com.coupang_olz.coupang_eats.ui.main.home

import com.coupang_olz.coupang_eats.data.local.Store

interface HomeStoreView {
    fun onStoreLoading()
    fun onStoreSucess(stores: ArrayList<Store>)
    fun onStoreFailure(code: Int, message: String)
}