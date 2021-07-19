package com.martinlaizg.geofind.data.api

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import retrofit2.Call
import retrofit2.http.GET

interface TourApiInterface {
    
    /**
     * Get all tours
     */
    @GET("/tour")
    fun getAllTours(): Call<List<TourApiBean>>
}