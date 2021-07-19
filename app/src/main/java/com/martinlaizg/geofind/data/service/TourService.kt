package com.martinlaizg.geofind.data.service

import com.martinlaizg.geofind.data.api.RetrofitClient
import com.martinlaizg.geofind.data.api.TourApiInterface
import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ApiException
import com.martinlaizg.geofind.data.exception.ConnectionException
import java.io.IOException

class TourService {

	private val api: TourApiInterface =
		RetrofitClient().instance.create(TourApiInterface::class.java)

	fun getAllTours(): List<TourApiBean> {
		try {
			val response = api.getAllTours().execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: Exception) {
			throw ConnectionException("Connection error")
		}
		throw ApiException("Response unsuccessful")
	}
}