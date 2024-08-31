package com.example.valowiki.models

import java.io.Serializable

data class ApiAgentResponseModel(
    val `data`: List<Data>,
    val status: Int
): Serializable