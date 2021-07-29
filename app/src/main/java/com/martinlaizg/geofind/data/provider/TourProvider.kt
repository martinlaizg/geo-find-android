package com.martinlaizg.geofind.data.provider

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.data.exception.ConnectionException
import com.martinlaizg.geofind.data.service.TourService

/**
 *
 */
class TourProvider {

	private val tourService: TourService = TourService()

	/**
	 *
	 */
	fun getTourList(onSuccess: (List<TourApiBean>) -> Unit, onError: (String) -> Unit) {
		Thread {
			try {
				onSuccess(tourService.getAllTours())
			} catch (e: ConnectionException) {
				onError("Connection error")
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
				onError("Connection error")
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
				onError("Connection error")
			}
		}.start()
	}
}
