package com.martinlaizg.geofind.ui.tourlist

import com.martinlaizg.geofind.data.adapter.TourAdapter
import com.martinlaizg.geofind.data.service.TourService

class TourListProvider {

    val tourService: TourService = TourService()

    fun getTourList(): List<TourView> {
        return TourAdapter().adaptList(tourService.getAllTours())
    }
}