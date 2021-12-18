package com.coupang_olz.coupang_eats.data.remote.auth

import com.google.gson.annotations.SerializedName

data class UserInfo(@SerializedName("name")val name: String, @SerializedName("phoneNum") val phoneNum: String)
data class UserResponse(
    @SerializedName ("isSuccess") val isSuccess: Boolean,
    @SerializedName ("code")val code: Int,
    @SerializedName ("message")val message: String,
    @SerializedName ("result")val result: UserInfo?
)
