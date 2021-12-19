package com.coupang_olz.coupang_eats.data.remote.store

import android.annotation.SuppressLint
import android.util.Log
import com.coupang_olz.coupang_eats.data.local.Store

import com.coupang_olz.coupang_eats.data.remote.auth.getRetrofit
import com.coupang_olz.coupang_eats.ui.main.home.HomeStoreView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StoreService {
    private lateinit var homeStoreView: HomeStoreView

    fun setStoreView(storeView: HomeStoreView){
        this.homeStoreView = storeView
    }

    fun getStores(){
        val storeService = getRetrofit().create(StoreRetrofitInterface::class.java)

        homeStoreView.onStoreLoading()

        storeService.getStores().enqueue(object : Callback<StoreResponse> {
            @SuppressLint("LongLogTag")
            override fun onResponse(call: Call<StoreResponse>, response: Response<StoreResponse>) {
                Log.d("STORE/API-RESPONSE", response.toString())

                val resp = response.body()!!

                Log.d("STORE/API-RESPONSE-COU", resp.toString())

                when(resp.code){
                    1000 -> homeStoreView.onStoreSucess(resp.result.store)
                    else -> homeStoreView.onStoreFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<StoreResponse>, t: Throwable) {
                homeStoreView.onStoreFailure(3000, "값을 불러오는데 실패하였습니다.")
                homeStoreView.onStoreFailure(4000, "데이터베이스 연결에 실패하였습니다.")
                homeStoreView.onStoreFailure(5000, "서버와의 연결에 실패하였습니다.")
                homeStoreView.onStoreFailure(6000, "검색 결과 없음")
            }
        })
    }
}
