package com.martinlaizg.geofind.data.provider

import android.util.Log
import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ConnectionException
import com.martinlaizg.geofind.data.service.TourService

/**
 *
 */
class TourProvider {

	private val _tag = "TourProvider"
	private val tourService: TourService = TourService()

	private val _connectionError = "Connection error"

	/**
	 *
	 */
	fun getTourList(onSuccess: (List<TourApiBean>) -> Unit, onError: (String) -> Unit) {
		Thread {
			try {
				onSuccess(tourService.getAllTours())
			} catch (e: ConnectionException) {
				Log.e(_tag, e.message, e)
				onError(_connectionError)
			}
		}.start()
	}

	/**
	 *
	 */
	fun create(beanToCreate: TourApiBean, onSuccess: (TourApiBean) -> Unit,
		onError: (String) -> Unit) {
		Thread {
			try {
				onSuccess(tourService.create(beanToCreate))
			} catch (e: ConnectionException) {
				Log.e(_tag, e.message, e)
				onError(_connectionError)
			}
		}.start()
	}

	/**
	 *
	 */
	fun getTour(id: String, onSuccess: (TourApiBean) -> Unit, onError: (String) -> Unit) {
		Thread {
			try {
				onSuccess(tourService.getTour(id))
			} catch (e: ConnectionException) {
				Log.e(_tag, e.message, e)
				onError(_connectionError)
			}
		}.start()
	}

	/**
	 * Remove a tour by the id
	 *
	 * @param id
	 */
	fun removeTour(id: String) {
		Thread {
			try {
				tourService.removeTour(id)
			} catch (e: ConnectionException) {
				Log.e(_tag, e.message, e)
			}
		}.start()
	}
}
