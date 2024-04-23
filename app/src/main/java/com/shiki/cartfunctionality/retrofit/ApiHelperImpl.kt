package com.shiki.cartfunctionality.retrofit

import com.shiki.cartfunctionality.model.CartDetails
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject


class ApiHelperImpl @Inject constructor
    (private val apiService: RestApiService)
    :ApiHelper
{
    override suspend fun getcartdeail(typevalue:Int?):
            Response<CartDetails> =
        apiService.getCartItemsList(typevalue)
}