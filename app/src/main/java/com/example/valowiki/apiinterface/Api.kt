package com.example.valowiki.apiinterface

import android.telecom.Call

interface Api
    @GET("agents")
    fun getAgent(): Call<ApiAgentResponseModel>
}