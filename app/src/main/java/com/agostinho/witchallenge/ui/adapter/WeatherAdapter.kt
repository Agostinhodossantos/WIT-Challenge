package com.agostinho.witchallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agostinho.witchallenge.databinding.ItemWeatherBinding
import com.agostinho.witchallenge.models.WeatherResult


class  WeatherAdapter : ListAdapter<WeatherResult, WeatherAdapter.WeatherViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<WeatherResult>() {
        override fun areItemsTheSame(oldItem:WeatherResult, newItem:WeatherResult): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:WeatherResult, newItem:WeatherResult): Boolean {
            return oldItem == newItem
        }
    }

    inner class WeatherViewHolder(val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

//        Glide
//            .with(holder.binding.root)
//            .load(currentList[position].image)
//            .into(holder.binding.imageProduct)

    }
}