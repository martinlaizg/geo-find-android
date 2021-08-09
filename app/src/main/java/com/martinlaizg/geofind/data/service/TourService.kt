package com.martinlaizg.geofind.data.service

import android.util.Log
import com.martinlaizg.geofind.data.api.RetrofitClient
import com.martinlaizg.geofind.data.api.TourApiInterface
import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ConnectionException
import com.martinlaizg.geofind.data.exception.UnsuccessfulRequestException
import java.io.IOException

/**
 *
 */
class TourService {

	private val _connectionError = "Connection error"
	private val _tag: String = TourService::class.java.simpleName

	private val api: TourApiInterface =
		RetrofitClient().instance.create(TourApiInterface::class.java)

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
		throw UnsuccessfulRequestException()
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
		throw UnsuccessfulRequestException()
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
		throw UnsuccessfulRequestException()
	}

	/**
	 * Remove a tour by id
	 *
	 * @param id the tour id
	 */
	fun removeTour(id: String) {
		try {
			val response = api.deleteTour(id).execute()
			if (!response.isSuccessful) {
				throw UnsuccessfulRequestException()
			}
		} catch (e: IOException) {
			Log.e(_tag, _connectionError, e)
			throw ConnectionException()
		}
	}
}
