package com.agostinho.witchallenge.di


import com.agostinho.witchallenge.network.WeatherApi
import com.agostinho.witchallenge.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        weatherApi: WeatherApi,
    ): WeatherRepository {
        return WeatherRepository(weatherApi)
    }
}