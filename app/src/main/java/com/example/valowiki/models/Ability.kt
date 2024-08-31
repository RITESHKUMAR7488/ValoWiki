package com.example.valowiki.models

import java.io.Serializable

data class Ability(
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val slot: String
):Serializable