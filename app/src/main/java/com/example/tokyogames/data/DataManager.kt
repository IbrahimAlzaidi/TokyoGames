package com.example.tokyogames.data

import com.example.tokyogames.data.domain.Country

object DataManager {
    private var countryIndex = 1
    val countryList = mutableListOf<Country>()
    val country: List<Country>
    get() = countryList.toList()

    fun addCountry(country: Country) = countryList.add(country)

    fun getCurrentCountry(): Country = countryList[countryIndex]

    fun getNextCountry(): Country{
        countryIndex++
        if (countryIndex == countryList.size){
            countryIndex =0
        }
        return countryList[countryIndex]
    }

    fun getPrevCountry(): Country{
        countryIndex--
        if (countryIndex == -1){
            countryIndex = countryList.size -1
        }
        return countryList[countryIndex]
    }

    fun getCountryInfo(country: String) = countryList.filter { it.teamNoc.equals(country, true) }

    fun getAllCountries() = countryList
}