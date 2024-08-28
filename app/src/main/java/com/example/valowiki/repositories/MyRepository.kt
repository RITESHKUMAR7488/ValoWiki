package com.example.valowiki.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.valowiki.apiInterface.Api
import com.example.valowiki.models.ApiAgentResponseModel
import com.example.valowiki.models.ApiWeaponsResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository(private val api: Api) {
    fun getAgent(data:MutableLiveData<ApiAgentResponseModel>){
        api.getAgent().enqueue(object : Callback<ApiAgentResponseModel> {
            override fun onResponse(
                p0: Call<ApiAgentResponseModel>,
                p1: Response<ApiAgentResponseModel>
            ) {
                data.value=p1.body()
            }

            override fun onFailure(p0: Call<ApiAgentResponseModel>, p1: Throwable) {
                Log.d("Error", p1.message.toString())            }
        })
    }

    fun getWeapons(data: MutableLiveData<ApiWeaponsResponseModel>){
        api.getWeapons().enqueue(object : Callback<ApiWeaponsResponseModel> {
            override fun onResponse(
                p0: Call<ApiWeaponsResponseModel>,
                p1: Response<ApiWeaponsResponseModel>
            ) {
                data.value=p1.body()
            }

            override fun onFailure(p0: Call<ApiWeaponsResponseModel>, p1: Throwable) {
                Log.d("Error", p1.message.toString())
            }

        })
    }


    }



