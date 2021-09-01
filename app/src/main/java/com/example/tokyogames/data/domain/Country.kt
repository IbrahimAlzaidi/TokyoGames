package com.example.tokyogames.data.domain

data class Country(
    val rank: Int?,
    val teamNoc: String,
    val goldMedal: Int,
    val silverMedal:Int,
    val bronzeMedal: Int,
    val total: Int,
    val rankByTotal: Int,
    val nocCode: String
)