package com.coupang_olz.coupang_eats.ui.main.home

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.databinding.FragmentHomeBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.main.MainActivity
import com.coupang_olz.coupang_eats.ui.main.search.SearchFragment

class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var autopager: AutoPager //메인배너를 위한 스레드
    private val handler = Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    var currentPosition:Int = 0

    override fun initAfterBinding() {
        //toolbar -> action bar
        val activity = getActivity() as MainActivity
        val toolbar = binding.homeToobarTb
        activity.setSupportActionBar(toolbar)
        val ab = activity.supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

       //메인 배너 뷰페이저 연결
       val bannerAdapter = BannerViewpagerAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_img_1))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_img_2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_img_3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_img_4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_img_5))

        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //자동 스크롤 구현
        autopager = AutoPager()
        autopager.start()
    }

    //메인배너 자동 스크롤을 위한 setPage 함수
    fun setPage(){
        if(currentPosition == 4) currentPosition = 0
        binding.homeBannerVp.setCurrentItem(currentPosition, true)
        currentPosition ++
    }
    //배너를 위한 스레드
    inner class AutoPager(): Thread(){
        override fun run() {
            try {
                while(true){
                    sleep(5000)
                    handler.sendEmptyMessageAtTime(0, 2000)
                }
            }catch (e: InterruptedException){}
        }
    }



}