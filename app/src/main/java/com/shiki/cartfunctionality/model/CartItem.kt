package com.shiki.cartfunctionality.model

import com.google.gson.annotations.SerializedName

data class CartItem(
    @SerializedName("cart_id")
    var cartId: Int,
    @SerializedName("qty")
    var qty: Int,
    @SerializedName("data")
    var Cartdata: CartData)
