package com.example.valowiki.models

import java.io.Serializable

data class ApiMapsResponseModel(
    val `data`: List<DataXXX>,
    val status: Int
):Serializable