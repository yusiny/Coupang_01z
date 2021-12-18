package com.coupang_olz.coupang_eats.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerViewpagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    private val fragmentlist : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int  = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    //homeFragment에서 직접 접근 X, 여기서 홈프래그먼트에 추가해줌
    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size -1)
    }

}