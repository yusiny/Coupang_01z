package com.coupang_olz.coupang_eats.ui.main.myeats

import android.content.Intent
import com.coupang_olz.coupang_eats.databinding.FragmentMyeatsBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.siginup.SignUpActivity

class MyeatsFragment(): BaseFragment<FragmentMyeatsBinding>(FragmentMyeatsBinding::inflate) {

    override fun initAfterBinding() {
        binding.myeatsSignupBtnTv.setOnClickListener{
            startActivity(Intent(activity, SignUpActivity::class.java))
        }
    }
}