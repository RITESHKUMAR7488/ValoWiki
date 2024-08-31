package com.example.valowiki.models

import java.io.Serializable

data class ApiTiersResponseModel(
    val `data`: List<DataXX>,
    val status: Int
): Serializable