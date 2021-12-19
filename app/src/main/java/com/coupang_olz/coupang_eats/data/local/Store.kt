package com.coupang_olz.coupang_eats.data.local

data class Store(
   var restIdx: Int = 0,
   var restName: String = "",
   var restImg: String = "",
   var categoryIdx: Int = 0,
   var isCheetah: Int = 0,
   var rate: Double = 0.0,
   var deliveryFee: Int = 0,
   var minOrderFee: Int = 0,
)