package com.example.valowiki.models

import java.io.Serializable

data class Level(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val levelItem: String,
    val streamedVideo: String,
    val uuid: String
) :Serializable