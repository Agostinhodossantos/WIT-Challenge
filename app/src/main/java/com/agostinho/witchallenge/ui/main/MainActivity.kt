package com.agostinho.witchallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.agostinho.witchallenge.R
import com.agostinho.witchallenge.databinding.ActivityMainBinding
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.network.WeatherCityResponse
import com.agostinho.witchallenge.ui.adapter.WeatherAdapter
import com.agostinho.witchallenge.utils.DataState
import com.agostinho.witchallenge.utils.getCurrentTime
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WeatherAdapter
    private lateinit var rvCityWeather: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        subscribeObservers()
        subscribeObserversMyCity()
        viewModel.setStateEvent(MainStateEvent.GetWeatherGroup)
        viewModel.setStateEvent(MainStateEvent.GetWeatherByCity)

    }

    private fun subscribeObserversMyCity() {
        viewModel.dataStateCity.observe(this, Observer { dataState ->
            when(dataState) {
                is DataState.Success<WeatherCityResponse> -> {
                    displayCityWeather(dataState.data)
                }
                is DataState.Loading -> {

                }
                is DataState.Error -> {
                    Toast.makeText(this, "Error ${dataState.exception}", Toast.LENGTH_LONG).show()

                }
            }
        })
    }

    private fun displayCityWeather(weather: WeatherCityResponse) {
        binding.tvCity.text = weather.name
        binding.tvTemp.text = weather.main.getTemp
        binding.tvTime.text = "Hoje, ${getCurrentTime()}"

        Glide
            .with(this)
            .load(weather.weather.get(0).getIconUrlLarge)
            .into(binding.imgIcon)

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<WeatherResult>> -> {
                    displayLoading(false)
                    populateRecyclerView(dataState.data)
                }
                is DataState.Loading -> {
                    displayLoading(true)
                }
                is DataState.Error -> {
                    displayLoading(false)
                    displayError(dataState.exception.message)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message.isNullOrEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Unknown error", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun populateRecyclerView(data: List<WeatherResult>) {
        adapter.submitList(data)
        rvCityWeather.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        rvCityWeather.adapter = adapter
    }


    private fun setupRecyclerView() {
        adapter = WeatherAdapter()
        rvCityWeather = binding.root.findViewById(R.id.rv_cities_weather);
    }
}