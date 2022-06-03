package com.agostinho.witchallenge.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agostinho.witchallenge.databinding.ActivityWeatherDetailBinding
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.utils.WEATHER_INTENT
import com.bumptech.glide.Glide


class WeatherDetail : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityWeatherDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: WeatherResult? = intent.getParcelableExtra<WeatherResult>(WEATHER_INTENT)
        data.let {
            it?.let { it1 -> setupUI(it1) }
        }

    }

    private fun setupUI(weather: WeatherResult) {
        binding.tvCity.text = weather.name
        binding.tvTemp.text = weather.main.getTemp
        binding.tvDescription.text = weather.weather.get(0).description
        binding.tvHumidity.text = weather.main.humidity.toString()
        binding.tvPressure.text = weather.main.pressure.toString()
        binding.tvTimezone.text = weather.timezone.toString()
        binding.tvWind.text = weather.wind.speed.toString()


        Glide
            .with(this)
            .load(weather.weather.get(0).getIconUrlLarge)
            .into(binding.imgIcon)
    }
}