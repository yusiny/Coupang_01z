package com.coupang_olz.coupang_eats.ui.main

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.coupang_olz.coupang_eats.R
import com.coupang_olz.coupang_eats.databinding.ActivityMainBinding
import com.coupang_olz.coupang_eats.ui.BaseActivity

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    override fun initAfterBinding() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.mainBottomNavigation.setupWithNavController(navController)
    }

}