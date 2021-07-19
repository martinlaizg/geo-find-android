package com.martinlaizg.geofind.ui.tourlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TourListViewModel : ViewModel() {

	private val _tag: String = this::class.java.simpleName

	private val provider: TourListProvider = TourListProvider()

	private val _data = MutableLiveData<List<TourView>>().apply {
		Log.d(_tag, "Initialize data")
		value = listOf()
	}

	val data: LiveData<List<TourView>> = _data
		get() {
			Thread {
				loadData()
			}.start()
			return field
		}

	private fun loadData() {
		_data.postValue(provider.getTourList())
	}
}