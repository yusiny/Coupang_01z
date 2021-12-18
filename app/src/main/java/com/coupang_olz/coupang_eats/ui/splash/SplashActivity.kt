package com.coupang_olz.coupang_eats.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.coupang_olz.coupang_eats.databinding.ActivitySplashBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity
import com.coupang_olz.coupang_eats.ui.main.MainActivity

class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun initAfterBinding() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 2000)
    }

}