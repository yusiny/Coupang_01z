package com.coupang_olz.coupang_eats.ui.main.home

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.databinding.FragmentHomeBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.main.MainActivity
import com.coupang_olz.coupang_eats.ui.main.search.SearchFragment

class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initAfterBinding() {
        //toolbar -> action bar
        val activity = getActivity() as MainActivity
        val toolbar = binding.homeToobarTb
        activity.setSupportActionBar(toolbar)
        val ab = activity.supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

       /* //search 아이콘 누르면 -> homeFragment()에서 searchFragment()
        binding.homeToolbarSearchBtnIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragment, SearchFragment())
                .commitAllowingStateLoss()
        }*/
    }




}