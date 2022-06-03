package com.agostinho.witchallenge.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agostinho.witchallenge.R
import com.agostinho.witchallenge.databinding.ActivityMainBinding
import com.agostinho.witchallenge.databinding.ActivityWeatherDetailBinding

class WeatherDetail : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityWeatherDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}