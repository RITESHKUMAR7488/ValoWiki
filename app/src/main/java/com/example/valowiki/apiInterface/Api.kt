package com.example.valowiki.apiInterface


import com.example.valowiki.models.ApiAgentResponseModel
import com.example.valowiki.models.ApiMapsResponseModel
import com.example.valowiki.models.ApiPlayerCardResponseModel
import com.example.valowiki.models.ApiTiersResponseModel
import com.example.valowiki.models.ApiWeaponsResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("agents")
    fun getAgent(): Call<ApiAgentResponseModel>

    @GET("weapons")
    fun getWeapons(): Call<ApiWeaponsResponseModel>

    @GET("competitivetiers")
    fun getTiers(): Call<ApiTiersResponseModel>

    @GET("abilities")
    fun getAbilities(): Call<ApiAgentResponseModel>

    @GET("maps")
    fun getMaps(): Call<ApiMapsResponseModel>

    @GET("playercards")
    fun getCard(): Call<ApiPlayerCardResponseModel>

}