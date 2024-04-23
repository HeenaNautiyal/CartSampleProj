package com.shiki.cartfunctionality.retrofit

import com.shiki.cartfunctionality.model.CartDetails
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface RestApiService {
    @POST("get-cart-details")
    @Multipart
    suspend fun
            getCartItemsList
                (@Part("type") typevalue: Int?):
            Response<CartDetails>
}