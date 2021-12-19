package com.coupang_olz.coupang_eats.data.remote.store

import com.coupang_olz.coupang_eats.data.local.Store
import com.google.gson.annotations.SerializedName

data class StoreResult( @SerializedName ("restaurantList") val store :ArrayList<Store>,)
data class StoreResponse(
    @SerializedName ("isSuccess") val isSuccess: Boolean,
    @SerializedName ("code")val code: Int,
    @SerializedName ("message")val message: String,
    @SerializedName ("result")val result: StoreResult
)