package com.coupang_olz.coupang_eats.utils

import com.coupang_olz.coupang_eats.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.coupang_olz.coupang_eats.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)
