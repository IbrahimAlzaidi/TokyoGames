package com.example.tokyogames.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import com.example.tokyogames.data.DataManager
import com.example.tokyogames.databinding.ActivityMainBinding
import com.example.tokyogames.ui.CountryAdapter
import com.example.tokyogames.util.CsvParser
import com.example.tokyogames.util.log
import org.eazegraph.lib.models.PieModel

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFile()
         adapter = CountryAdapter(DataManager.countryList)
        binding.recyclerCountry.adapter = adapter
    }

    private fun openFile(){
        val inputStream = assets.open("tokyo2021.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine { line ->
            val country = parser.parse(line)
            DataManager.addCountry(country)
        }

        DataManager.getAllCountries().log()

    }


}