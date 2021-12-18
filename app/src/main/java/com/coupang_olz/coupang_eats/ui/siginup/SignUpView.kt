package com.coupang_olz.coupang_eats.ui.siginup

interface SignUpView {
    fun onSignUpLoading()
    fun onSignUpSuccess()
    fun onSignUpFailure(code: Int, message: String)
}