package com.example.valowiki.models

import java.io.Serializable

data class ApiWeaponsResponseModel(
    val `data`: List<DataX>,
    val status: Int
): Serializable