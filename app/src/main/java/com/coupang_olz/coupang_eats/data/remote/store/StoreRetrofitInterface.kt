package com.coupang_olz.coupang_eats.data.remote.store

import retrofit2.Call
import retrofit2.http.*

interface StoreRetrofitInterface {
    @GET("restaurant")
    fun getStores(): Call<StoreResponse>
}