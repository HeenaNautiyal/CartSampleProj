package com.shiki.cartfunctionality.model

import com.google.gson.annotations.SerializedName

data class CartData(
    @SerializedName("product_name")
    var product_name: String,
    @SerializedName("unit_mrp")
    var unit_mrp: String,
    @SerializedName("promo_applied")
    var promo_applied: String,
    var remark: String)
