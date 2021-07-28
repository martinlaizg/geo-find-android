package com.martinlaizg.geofind.ui.tour

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martinlaizg.geofind.data.adapter.TourAdapter
import com.martinlaizg.geofind.data.provider.TourProvider
import com.martinlaizg.geofind.ui.view.TourView

class TourViewModel(private val id: String) : ViewModel() {

	private val provider = TourProvider()

	private val _data = MutableLiveData<TourView>()
	val data: LiveData<TourView> = _data
		get() {
			provider.getTour(id, onSuccess = {
				_data.postValue(TourAdapter.beanToView(it))
			}, onError = {
				_err.postValue(it)
			})
			return field
		}

	private val _err = MutableLiveData<String>()
	val err: LiveData<String> = _err

}