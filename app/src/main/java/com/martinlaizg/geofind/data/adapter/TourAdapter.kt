package com.martinlaizg.geofind.data.adapter

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.ui.view.TourView

class TourAdapter {

	companion object {

		fun beanToViewList(list: List<TourApiBean>): List<TourView> {
			return list.map { beanToView(it) }
		}

		fun viewToBeanList(list: List<TourView>): List<TourApiBean> {
			return list.map { viewToBean(it) }
		}

		fun beanToView(apiBean: TourApiBean): TourView {
			return TourView(apiBean._id, apiBean.name, apiBean.description).apply {
				image = apiBean.image
			}
		}

		fun viewToBean(view: TourView): TourApiBean {
			return TourApiBean(view.id, view.name, view.description).apply { image = view.image }
		}
	}
}