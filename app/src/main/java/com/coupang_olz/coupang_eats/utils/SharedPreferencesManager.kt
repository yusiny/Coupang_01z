package com.coupang_olz.coupang_eats.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.coupang_olz.coupang_eats.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.coupang_olz.coupang_eats.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)


fun isLogin(context: Context): Boolean {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getBoolean("isLogin", false)
}

fun setLoginStatus(context: Context, isLogin: Boolean){
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf!!.edit()

    editor.putBoolean("isLogin", isLogin)
    editor.apply()
}