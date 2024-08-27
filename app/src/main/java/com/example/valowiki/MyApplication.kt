package com.example.valowiki

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    lateinit var retrofit: Retrofit

override fun onCreate() {
super.onCreate()
retrofit= Retrofit.Builder()
    .baseUrl("https://valorant-api.com/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}
}