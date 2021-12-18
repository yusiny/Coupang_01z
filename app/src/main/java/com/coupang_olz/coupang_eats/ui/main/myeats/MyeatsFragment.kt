package com.coupang_olz.coupang_eats.ui.main.myeats

import android.content.Intent
import android.view.View
import com.coupang_olz.coupang_eats.databinding.FragmentMyeatsBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.login.LoginActivity
import com.coupang_olz.coupang_eats.ui.siginup.SignUpActivity
import com.coupang_olz.coupang_eats.utils.isLogin

class MyeatsFragment(): BaseFragment<FragmentMyeatsBinding>(FragmentMyeatsBinding::inflate) {

    override fun initAfterBinding() {
        binding.myeatsLogin2Tv.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        binding.myeatsSignupBtnTv.setOnClickListener{
            startActivity(Intent(activity, SignUpActivity::class.java))
        }

        val isLogin = isLogin(requireContext()!!)
        if(isLogin){
            //Login된 상태
            binding.myeatsUserV.visibility = View.VISIBLE
            binding.myeatsLoginareaV.visibility = View.GONE
        }else{
            //안된 상태
            binding.myeatsUserV.visibility = View.GONE
            binding.myeatsLoginareaV.visibility = View.VISIBLE
        }
    }
}