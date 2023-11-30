package com.example.genshinassistant.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.genshin.dev/"

private val moshiBuilder = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
    .build()

object APIService {
    val retrofitApiService: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }


}

