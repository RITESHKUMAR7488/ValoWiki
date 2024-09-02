package com.example.valowiki.models

import java.io.Serializable

data class Callout(
    val location: Location,
    val regionName: String,
    val superRegionName: String
): Serializable