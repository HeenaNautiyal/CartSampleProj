package com.shiki.cartfunctionality.repository

import com.shiki.cartfunctionality.retrofit.ApiHelper
import okhttp3.MultipartBody

import javax.inject.Inject

class CartRepository @Inject constructor (private val apiHelper: ApiHelper) {
    suspend fun getItemList(typevalue: Int?) = apiHelper.getcartdeail(typevalue)
}