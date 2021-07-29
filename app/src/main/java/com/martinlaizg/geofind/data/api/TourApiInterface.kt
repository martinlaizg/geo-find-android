package com.martinlaizg.geofind.data.api

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 *
 */
interface TourApiInterface {

	/**
	 * Get all tours
	 * @return list of tours
	 */
	@GET("/tour")
	fun getAllTours(): Call<List<TourApiBean>>

	/**
	 *  Create a tour
	 *  @param bean tour to be created
	 *  @return tour created
	 */
	@POST("/tour")
	fun create(@Body bean: TourApiBean): Call<TourApiBean>

	/**
	 * Get tour by id
	 * @param id the tour id
	 * @return the tour
	 */
	@GET("/tour/{id}")
	fun getTour(@Path("id") id: String): Call<TourApiBean>
}
