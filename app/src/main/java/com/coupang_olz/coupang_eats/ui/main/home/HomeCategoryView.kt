package com.coupang_olz.coupang_eats.ui.main.home

import com.coupang_olz.coupang_eats.data.local.Category
import kotlin.collections.ArrayList

interface HomeCategoryView {
    fun onCategoryLoading()
    fun onCategorySuccess(categories: ArrayList<Category>)
    fun onCategoryFailure(code: Int, message: String)
}