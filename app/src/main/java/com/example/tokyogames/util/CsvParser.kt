package com.example.tokyogames.util

import com.example.tokyogames.data.domain.Country

class CsvParser {
    fun parse(line: String): Country{
        val token = line.split(",")
        return Country(
            rank = token[Constants.ColumnIndex.RANK].toInt(),
            teamNoc = token[Constants.ColumnIndex.TEAMNOC],
            goldMedal = token[Constants.ColumnIndex.GOLD_MEDAL].toInt(),
            silverMedal = token[Constants.ColumnIndex.SILVER_MEDAL].toInt(),
            bronzeMedal = token[Constants.ColumnIndex.BRONZE_MEDAL].toInt(),
            total = token[Constants.ColumnIndex.TOTAL].toInt(),
            rankByTotal = token[Constants.ColumnIndex.RANK_BY_TOTAL].toInt(),
            nocCode = token[Constants.ColumnIndex.NOCCODE]
        )
    }
}