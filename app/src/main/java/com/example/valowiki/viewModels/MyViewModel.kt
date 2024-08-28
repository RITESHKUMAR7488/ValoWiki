package com.example.valowiki.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valowiki.models.ApiAgentResponseModel
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




}