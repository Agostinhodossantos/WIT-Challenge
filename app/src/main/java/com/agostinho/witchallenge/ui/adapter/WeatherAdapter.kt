package com.agostinho.witchallenge.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agostinho.witchallenge.databinding.ItemWeatherBinding
import com.agostinho.witchallenge.models.WeatherResult
import com.agostinho.witchallenge.ui.details.WeatherDetail
import com.agostinho.witchallenge.utils.WEATHER_INTENT
import com.bumptech.glide.Glide


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
        holder.binding.tvCity.text = getItem(position).name
        holder.binding.tvTempMax.text = getItem(position).main.getTempMax
        holder.binding.tvTempMin.text = getItem(position).main.getTempMin

        Glide
            .with(holder.binding.root)
            .load(getItem(position).weather.get(0).getIconUrlLarge)
            .into(holder.binding.imgIcon)

        holder.binding.cardWeather.setOnClickListener {
            Intent(holder.binding.root.context, WeatherDetail::class.java).apply {
                this.putExtra(WEATHER_INTENT, currentList[position].id)
                holder.binding.root.context.startActivity(this)
            }
        }

    }
}