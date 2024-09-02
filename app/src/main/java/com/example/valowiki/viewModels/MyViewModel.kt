package com.example.valowiki.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valowiki.models.ApiAgentResponseModel
import com.example.valowiki.models.ApiMapsResponseModel
import com.example.valowiki.models.ApiPlayerCardResponseModel
import com.example.valowiki.models.ApiTiersResponseModel
import com.example.valowiki.models.ApiWeaponsResponseModel
import com.example.valowiki.repositories.MyRepository

class MyViewModel(private val myRepository: MyRepository) : ViewModel() {

    fun getAgent(): MutableLiveData<ApiAgentResponseModel> {
        val data = MutableLiveData<ApiAgentResponseModel>()
        myRepository.getAgent(data)
        return data
}
    fun getWeapons(): MutableLiveData<ApiWeaponsResponseModel> {
        val data = MutableLiveData<ApiWeaponsResponseModel>()
        myRepository.getWeapons(data)
        return data

    }

    fun getMaps() : MutableLiveData<ApiMapsResponseModel> {
        val data = MutableLiveData<ApiMapsResponseModel>()
        myRepository.getMaps(data)
        return data

    }
    fun getCard() : MutableLiveData<ApiPlayerCardResponseModel> {
        val data = MutableLiveData<ApiPlayerCardResponseModel>()
        myRepository.getCard(data)
        return data
    }
    fun getTiers() : MutableLiveData<ApiTiersResponseModel> {
        val data = MutableLiveData<ApiTiersResponseModel>()
        myRepository.getTiers(data)
        return data

    }




}