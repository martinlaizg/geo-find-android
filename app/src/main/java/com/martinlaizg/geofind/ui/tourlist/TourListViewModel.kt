package com.martinlaizg.geofind.ui.tourlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TourListViewModel : ViewModel() {

	private val provider: TourListProvider = TourListProvider()

	private val _data = MutableLiveData<Array<TourView>>().apply {
		value = arrayOf()
	}
	val data: LiveData<Array<TourView>> = _data
		get() {
			loadData()
			return field
		}

	private fun loadData() {
		_data.value = provider.getTourList()
	}
}