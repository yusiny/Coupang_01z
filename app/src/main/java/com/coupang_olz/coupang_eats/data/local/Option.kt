package com.coupang_olz.coupang_eats.data.local

data class Option(
    var categoryIdx: Int = 0,
    var rate: String = "",
    var isCheeth: String = "false",
    var deliveryFree: Int = 0,
    var minOrderFree: Int = 0,
)
