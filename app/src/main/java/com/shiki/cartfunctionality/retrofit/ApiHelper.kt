package com.shiki.cartfunctionality.retrofit

import com.shiki.cartfunctionality.model.CartDetails
import okhttp3.MultipartBody
import retrofit2.Response

interface ApiHelper {
    suspend fun getcartdeail(type: Int?):
            Response<CartDetails>
}