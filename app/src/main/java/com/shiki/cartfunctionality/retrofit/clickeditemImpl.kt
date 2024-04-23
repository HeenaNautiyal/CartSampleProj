package com.shiki.cartfunctionality.retrofit

import com.shiki.cartfunctionality.model.CartItem
import com.shiki.cartfunctionality.ui.CartAdapter
import javax.inject.Inject

class clickeditemImpl @Inject constructor(): CartAdapter.OnItemClickListener {
    override fun onClicked(prodname: CartItem): CartItem = prodname
}