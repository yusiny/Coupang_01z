package com.coupang_olz.coupang_eats.data.remote.category

import android.annotation.SuppressLint
import android.util.Log
import com.coupang_olz.coupang_eats.data.local.Category
import com.coupang_olz.coupang_eats.data.local.category.CategoryResponse
import com.coupang_olz.coupang_eats.data.remote.auth.getRetrofit
import com.coupang_olz.coupang_eats.ui.main.home.HomeCategoryView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryService {
    private lateinit var homeCategoryView: HomeCategoryView

    fun setCategoryView(categoryView: HomeCategoryView){
        this.homeCategoryView = categoryView
    }

    fun getCategories(){
        val categoryService = getRetrofit().create(CategoryRetrofitInterface::class.java)

        homeCategoryView.onCategoryLoading()

        categoryService.getCategories().enqueue(object : Callback<CategoryResponse> {
            @SuppressLint("LongLogTag")
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                Log.d("CATEGORY/API-RESPONSE", response.toString())

                val resp = response.body()!!

                Log.d("CATEGORY/API-RESPONSE-COU", resp.toString())

                when(resp.code){
                    1000 -> homeCategoryView.onCategorySuccess(resp.result!!)
                    else -> homeCategoryView.onCategoryFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                homeCategoryView.onCategoryFailure(3000, "값을 불러오는데 실패하였습니다.")
                homeCategoryView.onCategoryFailure(4000, "데이터베이스 연결에 실패하였습니다.")
                homeCategoryView.onCategoryFailure(5000, "서버와의 연결에 실패하였습니다..")
            }
        })
    }
}
