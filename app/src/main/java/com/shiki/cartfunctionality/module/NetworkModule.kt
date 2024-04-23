package com.shiki.cartfunctionality.module

import com.shiki.cartfunctionality.retrofit.ApiHelper
import com.shiki.cartfunctionality.retrofit.ApiHelperImpl
import com.shiki.cartfunctionality.retrofit.RestApiService
import com.shiki.cartfunctionality.retrofit.clickeditemImpl
import com.shiki.cartfunctionality.ui.CartAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.kalmesh.in/FoodExpress/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = provideRetrofit().create(RestApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @Singleton
    @Provides
    fun provideGetQuotes(clickeditemImpl: clickeditemImpl): CartAdapter.OnItemClickListener =clickeditemImpl


}




