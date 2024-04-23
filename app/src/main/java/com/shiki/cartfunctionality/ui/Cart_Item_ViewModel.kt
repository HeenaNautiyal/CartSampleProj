package com.shiki.cartfunctionality.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiki.cartfunctionality.model.CartDetails
import com.shiki.cartfunctionality.model.CartItem
import com.shiki.cartfunctionality.model.Resource
import com.shiki.cartfunctionality.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject
import kotlin.let
import kotlin.toString

@HiltViewModel
class Cart_Item_ViewModel @Inject constructor(
    private val mainRepository: CartRepository)
    : ViewModel() {

    private val _res = MutableLiveData<Resource<CartDetails>>()

    val res : LiveData<Resource<CartDetails>>
        get() = _res


    val typevalue=1

    private val _openNewFragment = MutableLiveData<Boolean>()
    val openNewFragment: LiveData<Boolean>
        get() = _openNewFragment



    init {
        getCartList()
    }
     private fun getCartList()  = viewModelScope.launch {
        mainRepository.getItemList(typevalue).let {
            if (it.isSuccessful){
                _res.postValue(Resource.success(it.body()) as Resource<CartDetails>?)
            }else{
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    fun onItemClick() {
        _openNewFragment.value = true
    }

    // Reset the value of openNewFragment LiveData after handling the event
    fun onNewFragmentOpened() {
        _openNewFragment.value = false
    }
}