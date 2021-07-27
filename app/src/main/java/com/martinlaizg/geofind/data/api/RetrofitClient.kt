package com.martinlaizg.geofind.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

	private val _dateFormat: String = "yyyy-MM-dd HH:mm:ss"
	private val _baseUrl: String = "http://10.0.2.2:3000"

	val instance: Retrofit = getRetrofit()

	private fun getRetrofit(): Retrofit {
		val gson = GsonBuilder().setDateFormat(_dateFormat).create()
		return Retrofit.Builder().baseUrl(_baseUrl)
			.addConverterFactory(GsonConverterFactory.create(gson)).build()
	}
}