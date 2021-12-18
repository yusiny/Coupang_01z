package com.coupang_olz.coupang_eats.ui.login



interface LoginView {
    fun onLoginLoading()

    fun onLoginFailure(code: Int, message: String)
}