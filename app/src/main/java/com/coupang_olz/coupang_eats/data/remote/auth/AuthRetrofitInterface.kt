package com.coupang_olz.coupang_eats.data.remote.auth

import com.coupang_olz.coupang_eats.data.local.User
import retrofit2.Call
import retrofit2.http.*

interface AuthRetrofitInterface {
    @POST("users/sign-up")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("users/log-in")
    fun login(@Body user: User): Call<AuthResponse>

    /*@GET("/users/auto-login")
    fun autoLogin(
        @Header ("X-ACCESS-TOKEN") jwt: String
    ): Call<AuthResponse>*/

    @GET("users/{userIdx}")
    fun getLogin(@Path("userIdx") userIdx: Int): Call<UserResponse>
}