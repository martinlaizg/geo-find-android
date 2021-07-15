package com.martinlaizg.geofind.ui.tourlist

class TourListProvider {
	fun getTourList(): Array<TourView> {
		return arrayOf(TourView("Paseo por la montaña", "https://donde-esta.org/wp-content/uploads/2018/08/D%C3%B3nde-est%C3%A1-la-monta%C3%B1a-Kanchenjunga.png"),
			TourView("Viaje al pasado", "https://www.healththoroughfare.com/wp-content/uploads/2018/05/time-travel.png"),
			TourView("Contando las baldosas", "https://www.projectkinect.com/wp-content/uploads/2011/06/DSCN7097.jpg"),
			TourView("Arriba y a volar"))
	}
}