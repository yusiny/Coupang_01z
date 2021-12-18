package com.coupang_olz.coupang_eats.ui.main.myeats

import com.coupang_olz.coupang_eats.data.remote.auth.Auth
import com.coupang_olz.coupang_eats.data.remote.auth.UserInfo

interface MyeatsView {
    fun onSetUserLoading()
    fun onSetUserSuccess(userInfo: UserInfo)
    fun onSetUserFailure(code: Int, message: String)
}