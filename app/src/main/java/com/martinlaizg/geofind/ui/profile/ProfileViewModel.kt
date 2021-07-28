package com.martinlaizg.geofind.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martinlaizg.geofind.ui.view.ProfileView

class ProfileViewModel : ViewModel() {

	private val provider = ProfileProvider()

	private val _text = MutableLiveData<ProfileView>()

	val text: LiveData<ProfileView> = _text
		get() {
			loadProfile()
			return field
		}

	private fun loadProfile() {
		provider.loadProfile {
			_text.postValue(it)
		}
	}
}