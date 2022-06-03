package com.agostinho.witchallenge.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.repository.WeatherRepository
import com.agostinho.witchallenge.utils.API_KEY
import com.agostinho.witchallenge.utils.DataState
import com.agostinho.witchallenge.utils.EUROPEAN_CITIES_LIST
import com.agostinho.witchallenge.utils.UNITS_METRIC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<WeatherResult>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<WeatherResult>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
       viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetWeatherEvents -> {
                    weatherRepository.getCitiesWeather(
                        EUROPEAN_CITIES_LIST,
                        API_KEY, UNITS_METRIC)
                        .onEach { dataState ->
                           _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    // No action
                }
            }
        }
    }
}


sealed class MainStateEvent {
    object GetWeatherEvents : MainStateEvent()
    object None : MainStateEvent()
}

