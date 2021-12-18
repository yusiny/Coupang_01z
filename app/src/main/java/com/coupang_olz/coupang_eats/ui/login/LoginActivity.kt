package com.coupang_olz.coupang_eats.ui.login

import android.view.View
import com.coupang_olz.coupang_eats.databinding.ActivityLoginBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

}