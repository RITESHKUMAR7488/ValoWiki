package com.example.valowiki.models

import java.io.Serializable

data class DataXX(
    val assetObjectName: String,
    val assetPath: String,
    val tiers: List<Tier>,
    val uuid: String
): Serializable