package com.agostinho.witchallenge.di

import com.agostinho.witchallenge.network.WeatherApi
import com.agostinho.witchallenge.utils.BASE_API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {

        var aLogger = HttpLoggingInterceptor()
        aLogger.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(aLogger)

        return Retrofit.Builder()
            .baseUrl(BASE_API)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))

    }

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit.Builder): WeatherApi {
        return retrofit
            .build()
            .create(WeatherApi::class.java)
    }
}