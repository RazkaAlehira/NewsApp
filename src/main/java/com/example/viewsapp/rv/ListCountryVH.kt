package com.example.viewsapp.rv

import androidx.recyclerview.widget.RecyclerView

class ListCountryVH(private val binding: ListCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // fungsi bind digunakan untuk mendapatkan data dari recyclerview Adapter
    fun bind(data: CountriesItem) {
        binding.txtCountryName.text = data.country
        binding.txtTotalCase.text = data.totalConfirmed.toString()
        binding.txtTotalRecovered.text = data.totalRecovered.toString()
        binding.txtTotalDeaths.text = data.totalDeaths.toString()
    }
}