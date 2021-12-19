package com.coupang_olz.coupang_eats.data.local.category

import com.coupang_olz.coupang_eats.data.local.Category
import com.google.gson.annotations.SerializedName


data class CategoryResponse(
    @SerializedName ("isSuccess") val isSuccess: Boolean,
    @SerializedName ("code")val code: Int,
    @SerializedName ("message")val message: String,
    @SerializedName ("result")val result: ArrayList<Category>?
)