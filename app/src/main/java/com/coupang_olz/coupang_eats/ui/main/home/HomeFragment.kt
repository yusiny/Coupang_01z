package com.coupang_olz.coupang_eats.ui.main.home

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.coupang_olz.coupang_eats.databinding.FragmentHomeBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.main.MainActivity

class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initAfterBinding() {
        val activity = getActivity() as MainActivity
        val toolbar = binding.homeToobarTb
        activity.setSupportActionBar(toolbar)
        val ab = activity.supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
    }


}