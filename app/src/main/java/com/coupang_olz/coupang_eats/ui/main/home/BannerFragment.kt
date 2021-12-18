package com.coupang_olz.coupang_eats.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coupang_olz.coupang_eats.databinding.FragmentBannerBinding

class BannerFragment(val imgRes: Int) : Fragment() {
    lateinit var binding : FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container, false)

        binding.homeBannerImageIv.setImageResource(imgRes)

        return binding.root
    }
}