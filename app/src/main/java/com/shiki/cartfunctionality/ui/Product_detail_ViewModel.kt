package com.shiki.cartfunctionality.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shiki.cartfunctionality.model.CartDetails
import com.shiki.cartfunctionality.model.Resource
import com.shiki.cartfunctionality.model.productDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Product_detail_ViewModel @Inject constructor(): ViewModel() {
    private val _prodres = MutableLiveData<productDetails>()
    val prodres : LiveData<productDetails>
        get() = _prodres

}