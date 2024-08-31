package com.example.valowiki.models

import java.io.Serializable

data class Role(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val uuid: String
):Serializable