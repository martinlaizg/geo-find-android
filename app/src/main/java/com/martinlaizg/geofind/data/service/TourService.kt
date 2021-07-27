package com.martinlaizg.geofind.data.service

import android.util.Log
import com.martinlaizg.geofind.data.api.RetrofitClient
import com.martinlaizg.geofind.data.api.TourApiInterface
import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ApiException
import com.martinlaizg.geofind.data.exception.ConnectionException

class TourService {

	private val _tag: String = TourService::class.java.simpleName

	private val api: TourApiInterface =
		RetrofitClient().instance.create(TourApiInterface::class.java)

	fun getAllTours(): List<TourApiBean> {
		try {
			val response = api.getAllTours().execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: Exception) {
			Log.e(_tag, "Connection error", e)
			throw ConnectionException("Connection error")
		}
		throw ApiException("Response unsuccessful")
	}

	fun create(tour: TourApiBean): TourApiBean {
		try {
			val response = api.create(tour).execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: Exception) {
			Log.e(_tag, "Connection error", e)
			throw ConnectionException("Connection error")
		}
		throw ApiException("Response unsuccessful")

	}

	fun getTour(id: String): TourApiBean {
		try {
			val response = api.getTour(id).execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: Exception) {
			Log.e(_tag, "Connection error", e)
			throw ConnectionException("Connection error")
		}
		throw ApiException("Response unsuccessful")
	}
}