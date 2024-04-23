package com.shiki.cartfunctionality.model

import com.google.gson.annotations.SerializedName

data class CartDetails(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message1:String,
    @SerializedName("data")
    val data1:ArrayList<CartItem>
)
