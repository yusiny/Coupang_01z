package com.coupang_olz.coupang_eats.ui.main.myeats

import android.content.Intent
import android.view.View
import com.coupang_olz.coupang_eats.data.remote.auth.Auth
import com.coupang_olz.coupang_eats.data.remote.auth.AuthService
import com.coupang_olz.coupang_eats.data.remote.auth.UserInfo
import com.coupang_olz.coupang_eats.databinding.FragmentMyeatsBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.login.LoginActivity
import com.coupang_olz.coupang_eats.ui.siginup.SignUpActivity
import com.coupang_olz.coupang_eats.utils.getJwt
import com.coupang_olz.coupang_eats.utils.getUserIdx
import com.coupang_olz.coupang_eats.utils.isLogin
import com.coupang_olz.coupang_eats.utils.setLoginStatus

class MyeatsFragment(): BaseFragment<FragmentMyeatsBinding>(FragmentMyeatsBinding::inflate), MyeatsView {

    override fun initAfterBinding() {
        binding.myeatsLogin2Tv.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        binding.myeatsSignupBtnTv.setOnClickListener{
            startActivity(Intent(activity, SignUpActivity::class.java))
        }
        binding.myeatsLogoutTv.setOnClickListener {
            setLoginStatus(requireContext(), false)

        }

        val isLogin = isLogin(requireContext()!!)
        if(isLogin){
            //Login된 상태
            binding.myeatsUserV.visibility = View.VISIBLE
            binding.myeatsLoginareaV.visibility = View.GONE

            //init user
            initUser()
        }else{
            //안된 상태
            binding.myeatsUserV.visibility = View.GONE
            binding.myeatsLoginareaV.visibility = View.VISIBLE
        }
    }

    private fun initUser(){
        val userIdx = getUserIdx(requireContext())

        if(userIdx != 0){
            val authService = AuthService()
            authService.setMyeatsView(this)
            authService.SetUser(userIdx)
        }
    }

    override fun onSetUserLoading() {
        //로딩
    }

    override fun onSetUserSuccess(userInfo: UserInfo) {
        binding.myeatsUsernameTv.text = userInfo.name
        binding.myeatsPhonenumberTv.text = userInfo.phoneNum
    }


    override fun onSetUserFailure(code: Int, message: String) {
        when(code){
            4000 -> {
//                binding.loginErrorTv.visibility = View.VISIBLE
//                binding.loginErrorTv.text = message
            }
        }
    }
}