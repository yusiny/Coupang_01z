package com.coupang_olz.coupang_eats.ui.splash

interface SplashView {
    fun onAutoLoginLoading()
    fun onAutoLoginSuccess()
    fun onAutoLoginFailure(code: Int, message: String)
}