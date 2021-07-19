package com.martinlaizg.geofind.data.adapter

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.ui.tourlist.TourView

class TourAdapter {

    fun adaptList(list: List<TourApiBean>): List<TourView>{
        return list.map { adapt(it) }
    }

    fun adapt(apiBean: TourApiBean): TourView {
        return TourView(apiBean.name,apiBean.image)
    }
}