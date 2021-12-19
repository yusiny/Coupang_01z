package com.coupang_olz.coupang_eats.data.remote.category

import com.coupang_olz.coupang_eats.data.local.category.CategoryResponse
import retrofit2.Call
import retrofit2.http.*

interface CategoryRetrofitInterface {
    @GET("category")
    fun getCategories(): Call<CategoryResponse>
}