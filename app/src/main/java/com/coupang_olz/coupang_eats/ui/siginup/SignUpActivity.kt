package com.coupang_olz.coupang_eats.ui.siginup

import android.util.Log
import android.view.View
import android.widget.Toast
import com.coupang_olz.coupang_eats.data.local.User
import com.coupang_olz.coupang_eats.data.remote.auth.AuthService
import com.coupang_olz.coupang_eats.databinding.ActivitySignupBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity

class SignUpActivity: BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate), SignUpView, View.OnClickListener {

    override fun initAfterBinding() {
        binding.signUpBackIv.setOnClickListener { finish() }
        binding.signUpSignUpBtn.setOnClickListener {
            signUp()
        }
    }
    override fun onClick(p0: View?) {
    }


    private fun signUp() {
        //입력 validation 처리
        if(binding.signUpIdEdittextEt.text.toString().isEmpty()){
            Toast.makeText(this, "이메일을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.signUpNameEdittextEt.text.toString().isEmpty()){
            Toast.makeText(this, "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.signUpPwEdittextEt.text.toString().isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.signUpPhoneEdittextEt.text.toString().isEmpty()){
            Toast.makeText(this, "휴대폰 번호를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val authService = AuthService()
        authService.setSignUpView(this)
        authService.signUp(getUser())
    }

    private fun getUser(): User {
        val email: String = binding.signUpIdEdittextEt.text.toString()
        val password: String = binding.signUpPwEdittextEt.text.toString()
        val name: String = binding.signUpNameEdittextEt.text.toString()
        val phoneNumber: String = binding.signUpPhoneEdittextEt.text.toString()


        return User(email, password, name, phoneNumber)
    }

    override fun onSignUpLoading() {
        //로딩바
        //binding.signuploadingbar.visibility = View.VISIBLE
    }

    override fun onSignUpSuccess() {
        //로딩바 GONE
        Log.d("SIGNUPACT/ASYNC/Async", "finish()")
        finish()
    }

    override fun onSignUpFailure(code: Int, message: String) {
        //로딩바 GONE

        when(code){
            2015, 2016, 2017 -> {
                binding.signUpIdErrorTv.visibility = View.VISIBLE
                binding.signUpIdErrorTv.text = message
            }
        }
    }



}