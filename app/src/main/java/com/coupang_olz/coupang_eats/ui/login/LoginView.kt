package com.coupang_olz.coupang_eats.ui.login

import com.coupang_olz.coupang_eats.data.remote.auth.Auth


interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code: Int, message: String)
}