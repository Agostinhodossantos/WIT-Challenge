package com.agostinho.witchallenge.ui.main

import androidx.lifecycle.*
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.network.WeatherCityResponse
import com.agostinho.witchallenge.repository.WeatherRepository
import com.agostinho.witchallenge.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val _dataStateCity : MutableLiveData<DataState<WeatherCityResponse>> = MutableLiveData()

    val dataState: LiveData<DataState<List<WeatherResult>>>
        get() = _dataState

    val dataStateCity: LiveData<DataState<WeatherCityResponse>>
        get() = _dataStateCity

    fun setStateEvent(mainStateEvent: MainStateEvent) {
       viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetWeatherGroup -> {
                    weatherRepository.getCitiesWeather(
                        EUROPEAN_CITIES_LIST,
                        API_KEY, UNITS_METRIC)
                        .onEach { dataState ->
                           _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.GetWeatherByCity -> {
                    weatherRepository.getWeatherByCityName(
                        MY_CITY, API_KEY, UNITS_METRIC)
                        .onEach { dataStateCity ->
                            _dataStateCity.value = dataStateCity
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
    object GetWeatherGroup : MainStateEvent()
    object GetWeatherByCity : MainStateEvent()
    object None : MainStateEvent()
}

