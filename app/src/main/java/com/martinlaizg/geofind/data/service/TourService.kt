package com.martinlaizg.geofind.data.service

import android.util.Log
import com.martinlaizg.geofind.data.api.RetrofitClient
import com.martinlaizg.geofind.data.api.TourApiInterface
import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ApiException
import com.martinlaizg.geofind.data.exception.ConnectionException
import java.io.IOException

/**
 *
 */
class TourService {

	private val _connectionError = "Connection error"
	private val _tag: String = TourService::class.java.simpleName

	private val api: TourApiInterface =
		RetrofitClient().instance.create(TourApiInterface::class.java)

	private val _responseUnsuccessful = "Response unsuccessful"

	/**
	 * TODO
	 *
	 * @return
	 */
	fun getAllTours(): List<TourApiBean> {
		try {
			val response = api.getAllTours().execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: IOException) {
			Log.e(_tag, _connectionError, e)
			throw ConnectionException()
		}
		throw ApiException(_responseUnsuccessful)
	}

	/**
	 * TODO
	 *
	 * @param tour
	 * @return
	 */
	fun create(tour: TourApiBean): TourApiBean {
		try {
			val response = api.create(tour).execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: IOException) {
			Log.e(_tag, _connectionError, e)
			throw ConnectionException()
		}
		throw ApiException(_responseUnsuccessful)
	}

	/**
	 * TODO
	 *
	 * @param id
	 * @return
	 */
	fun getTour(id: String): TourApiBean {
		try {
			val response = api.getTour(id).execute()
			if (response.isSuccessful) {
				return response.body()!!
			}
		} catch (e: IOException) {
			Log.e(_tag, _connectionError, e)
			throw ConnectionException()
		}
		throw ApiException(_responseUnsuccessful)
	}
}
