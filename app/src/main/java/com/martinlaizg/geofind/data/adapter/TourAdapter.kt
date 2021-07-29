package com.martinlaizg.geofind.data.adapter

import com.martinlaizg.geofind.data.api.bean.TourApiBean
import com.martinlaizg.geofind.ui.view.TourView

/**
 * TODO
 *
 */

object TourAdapter {

	/**
	 * TODO
	 *
	 * @param list
	 * @return
	 */
	fun beanToViewList(list: List<TourApiBean>): List<TourView> {
		return list.map { beanToView(it) }
	}

	/**
	 * TODO
	 *
	 * @param apiBean
	 * @return
	 */
	fun beanToView(apiBean: TourApiBean): TourView {
		return TourView(apiBean._id, apiBean.name, apiBean.description).apply {
			image = apiBean.image
		}
	}

	/**
	 * TODO
	 *
	 * @param view
	 * @return
	 */
	fun viewToBean(view: TourView): TourApiBean {
		return TourApiBean(view.id, view.name, view.description).apply { image = view.image }
	}
}
