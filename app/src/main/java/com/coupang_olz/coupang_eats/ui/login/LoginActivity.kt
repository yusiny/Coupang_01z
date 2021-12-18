package com.coupang_olz.coupang_eats.ui.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.coupang_olz.coupang_eats.data.local.User
import com.coupang_olz.coupang_eats.data.remote.auth.Auth
import com.coupang_olz.coupang_eats.data.remote.auth.AuthService
import com.coupang_olz.coupang_eats.databinding.ActivityLoginBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity
import com.coupang_olz.coupang_eats.ui.main.MainActivity
import com.coupang_olz.coupang_eats.utils.saveJwt
import com.coupang_olz.coupang_eats.utils.saveUserIdx
import com.coupang_olz.coupang_eats.utils.setLoginStatus

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),LoginView, View.OnClickListener {

    override fun initAfterBinding() {
        binding.signInExitIv.setOnClickListener {
            finish()
        }

        binding.signInSignInBtn.setOnClickListener {
            login()
        }
    }

    override fun onClick(v: View?) {

    }

    private fun login(){
        //validation
        if (binding.signInIdEdittextEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        //비밀번호 validation 처리
        if (binding.signInPwEdittextEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val email: String = binding.signInIdEdittextEt.text.toString()
        val password: String = binding.signInPwEdittextEt.text.toString()
        val user = User(email, password, "", "")

        val authService = AuthService()
        authService.setLoginView(this)
        authService.login(user)
    }

    override fun onLoginLoading() {
        //로딩
    }

    override fun onLoginSuccess(auth: Auth) {
        //jwt저장과 로그인 상태 저장
        saveJwt(auth.jwt)
        saveUserIdx(this, auth.userIdx)
        setLoginStatus(this, true)

        //mainActivity 시작
        startActivity(Intent(this, MainActivity::class.java))

        //finish
        finish()
    }

    override fun onLoginFailure(code: Int, message: String) {
        when(code){
            2015, 2019, 3014 -> {
//                binding.loginErrorTv.visibility = View.VISIBLE
//                binding.loginErrorTv.text = message
            }
        }
    }

}