package com.example.valowiki.models

import java.io.Serializable

data class AdsStats(
    val burstCount: Int,
    val fireRate: Double,
    val firstBulletAccuracy: Double,
    val runSpeedMultiplier: Double,
    val zoomMultiplier: Double
):Serializable