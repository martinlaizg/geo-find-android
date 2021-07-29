package com.martinlaizg.geofind.ui.tourlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martinlaizg.geofind.data.adapter.TourAdapter
import com.martinlaizg.geofind.data.provider.TourProvider
import com.martinlaizg.geofind.ui.view.TourView

/**
 *
 */
class TourListViewModel : ViewModel() {

	private val provider: TourProvider = TourProvider()

	private val _data = MutableLiveData<List<TourView>>()

	/**
	 *
	 */
	val data: LiveData<List<TourView>> = _data
		get() {
			provider.getTourList(onSuccess = {
				_data.postValue(TourAdapter.beanToViewList(it))
			}, onError = {
				_err.postValue(it)
			})
			return field
		}

	private val _err = MutableLiveData<String>()

	/**
	 *
	 */
	val err: LiveData<String> = _err
}
