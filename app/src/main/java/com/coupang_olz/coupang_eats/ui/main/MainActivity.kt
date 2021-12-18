package com.coupang_olz.coupang_eats.ui.main

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.databinding.ActivityMainBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment

    override fun initAfterBinding() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController: NavController = navHostFragment.findNavController()

        binding.mainBottomNavigation.setupWithNavController(navController)
    }
}