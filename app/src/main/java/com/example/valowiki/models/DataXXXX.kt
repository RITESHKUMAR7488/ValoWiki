package com.example.valowiki.models

import java.io.Serializable

data class DataXXXX(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val isHiddenIfNotOwned: Boolean,
    val largeArt: String,
    val smallArt: String,
    val themeUuid: String,
    val uuid: String,
    val wideArt: String
): Serializable