package com.agostinho.witchallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.agostinho.witchallenge.R
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetWeatherEvents)


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
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun displayLoading(b: Boolean) {

    }

    private fun populateRecyclerView(data: List<WeatherResult>) {
        Toast.makeText(this, "data $data", Toast.LENGTH_LONG).show()
    }


    private fun setupRecyclerView() {
    }
}