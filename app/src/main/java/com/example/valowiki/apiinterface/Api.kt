package com.example.valowiki.apiinterface

import android.telecom.Call
import com.example.valowiki.models.ApiAgentResponseModel
import retrofit2.http.GET

interface Api{
    @GET("agents")
    fun getAgent(): Call<ApiAgentResponseModel>
}