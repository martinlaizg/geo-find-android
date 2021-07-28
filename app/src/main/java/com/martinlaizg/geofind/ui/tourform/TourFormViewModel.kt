package com.martinlaizg.geofind.ui.tourform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martinlaizg.geofind.data.adapter.TourAdapter
import com.martinlaizg.geofind.data.provider.TourProvider
import com.martinlaizg.geofind.ui.view.TourView

class TourFormViewModel : ViewModel() {

	val err: MutableLiveData<String> = MutableLiveData()
	val createdTour: MutableLiveData<TourView> = MutableLiveData()

	private val tourProvider: TourProvider = TourProvider()

	fun createTour(tourView: TourView) {
		tourProvider.create(TourAdapter.viewToBean(tourView), onSuccess = {
			createdTour.postValue(TourAdapter.beanToView(it))
		}, onError = {
			err.postValue(it)
		})
	}

}