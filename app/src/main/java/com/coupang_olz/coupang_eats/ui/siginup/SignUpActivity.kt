package com.coupang_olz.coupang_eats.ui.siginup

import android.view.View
import com.coupang_olz.coupang_eats.databinding.ActivitySignupBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity

class SignUpActivity: BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        binding.signUpBackIv.setOnClickListener(this)
        binding.signUpSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }


}