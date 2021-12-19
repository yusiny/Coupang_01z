package com.coupang_olz.coupang_eats.ui.main.home

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.data.local.Category
import com.coupang_olz.coupang_eats.data.local.Option
import com.coupang_olz.coupang_eats.data.local.Store
import com.coupang_olz.coupang_eats.data.remote.category.CategoryService
import com.coupang_olz.coupang_eats.databinding.FragmentHomeBinding
import com.coupang_olz.coupang_eats.ui.BaseFragment
import com.coupang_olz.coupang_eats.ui.main.MainActivity


class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), HomeCategoryView {

    private lateinit var autopager: AutoPager //메인배너를 위한 스레드
    private val handler = Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    var currentPosition:Int = 0
    private lateinit var menuRVAdpater: HomeMenuRVAdpater

    //store 검색 시, 활용할 option 정보
    private var option = Option()
    private var optionCnt = 0
    private var isTakeOut = false
    private var isDiscount = false

    override fun initAfterBinding() {
        initTB()
        initVP()

        initMenuRV()
        initStoreRV()

        //버튼 이벤트 리스너 달아서 상태 변환
        binding.homeTastyMenuReset.setOnClickListener {
            binding.homeTastyMenuReset.visibility = View.GONE
            binding.homeTastyMenuResetCnt.visibility = View.GONE

            if(option.isCheeth == "true"){setIsCheetah("true")}
            if(isTakeOut){setIsTakeOut()}
            if(isDiscount){setIsDiscount()}

            optionCnt = 0
        }
        binding.homeTastyMenuCheetah.setOnClickListener {
           setIsCheetah(option.isCheeth)
        }
        binding.homeTastyMenuTakeout.setOnClickListener {
            setIsTakeOut()
        }
        binding.homeTastyMenuDiscount.setOnClickListener{
           setIsDiscount()
        }
    }
    private fun setIsCheetah(isCheetah: String){
        if(isCheetah == "true"){
            option.isCheeth = "false"
            binding.homeTastyMenuCheetah.setBackgroundResource(R.drawable.box_grayline)
            binding.homeTastyMenuCheetahTv.setTextColor(Color.parseColor("#000000"))
            binding.homeTastyMenuCheetahIv.setImageResource(R.drawable.icon_reset)
            optCnt(-1)

        }else if(isCheetah == "false"){
            option.isCheeth = "true"
            binding.homeTastyMenuCheetah.setBackgroundResource(R.drawable.box_skyblue)
            binding.homeTastyMenuCheetahTv.setTextColor(Color.parseColor("#FFFFFF"))
            binding.homeTastyMenuCheetahIv.setImageResource(R.drawable.icon_reset_white)
            optCnt(+1)
        }
    }
    private fun setIsTakeOut(){
        isTakeOut = !isTakeOut
        if(isTakeOut){
            binding.homeTastyMenuTakeout.setBackgroundResource(R.drawable.box_skyblue)
            binding.homeTastyMenuTakeoutTv.setTextColor(Color.parseColor("#FFFFFF"))
            optCnt(+1)
        }else{
            binding.homeTastyMenuTakeout.setBackgroundResource(R.drawable.box_grayline)
            binding.homeTastyMenuTakeoutTv.setTextColor(Color.parseColor("#000000"))
            optCnt(-1)
        }
    }
    private fun setIsDiscount(){
        isDiscount = !isDiscount
        if(isDiscount){
            binding.homeTastyMenuDiscount.setBackgroundResource(R.drawable.box_skyblue)
            binding.homeTastyMenuDiscountTv.setTextColor(Color.parseColor("#FFFFFF"))
            optCnt(+1)
        }else{
            binding.homeTastyMenuDiscount.setBackgroundResource(R.drawable.box_grayline)
            binding.homeTastyMenuDiscountTv.setTextColor(Color.parseColor("#000000"))
            optCnt(-1)
        }
    }

    private fun optCnt(pm: Int){
        when(pm){
            +1 -> optionCnt ++
            -1 -> optionCnt --
        }

        if(optionCnt == 0){
            binding.homeTastyMenuReset.visibility = View.GONE
            binding.homeTastyMenuResetCnt.visibility =  View.GONE
        }else if(optionCnt >= 1){
            binding.homeTastyMenuReset.visibility = View.VISIBLE
            binding.homeTastyMenuResetCnt.visibility =  View.VISIBLE
            binding.homeTastyMenuResetCnt.text = optionCnt.toString()
        }
    }

    override fun onPause() {
        super.onPause()

        autopager.interrupt()
    }

    private fun initStoreRV() {
        val storeRVAdapter = HomeTastyRVAdapter()
        binding.homeTastyRv.adapter = storeRVAdapter
        binding.homeTastyRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val store = Store("크로플각 성남점")
        storeRVAdapter.addStore(store)
        storeRVAdapter.addStore(store)
        storeRVAdapter.addStore(store)
        storeRVAdapter.addStore(store)
        storeRVAdapter.addStore(store)
    }

    private fun initMenuRV() {
        menuRVAdpater = HomeMenuRVAdpater(requireContext())
        binding.homeMenuRv.adapter = menuRVAdpater
        binding.homeMenuRv.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)

        val categoryService = CategoryService()
        categoryService.setCategoryView(this)
        categoryService.getCategories()
    }

    private fun initTB() {
        //toolbar -> action bar
        val activity = getActivity() as MainActivity
        val toolbar = binding.homeToobarTb
        activity.setSupportActionBar(toolbar)
        val ab = activity.supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

        binding.homeToolbarSearchIv.setOnClickListener {
            (context as MainActivity).navController.navigate(R.id.searchFragment)
        }
    }

    private fun initVP() {
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
    fun setPage(){
        if(currentPosition == 4) currentPosition = 0
        binding.homeBannerVp.setCurrentItem(currentPosition, true)
        currentPosition ++
    }
    inner class AutoPager(): Thread(){
        override fun run() {
            try {
                while(true){
                    sleep(5000)
                    handler.sendEmptyMessageAtTime(0, 5000)
                }
            }catch (e: InterruptedException){}
        }
    }

    override fun onCategoryLoading() {}

    override fun onCategorySuccess(categories: ArrayList<Category>) {
        menuRVAdpater.addCategories(categories)
    }

    override fun onCategoryFailure(code: Int, message: String) {

    }


}