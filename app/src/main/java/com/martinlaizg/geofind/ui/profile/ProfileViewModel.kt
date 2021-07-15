package com.martinlaizg.geofind.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

	private val profileProvider = ProfileProvider()
	private val _text = MutableLiveData<ProfileView>()

	val text: LiveData<ProfileView> = _text
		get() {
			loadProfile()
			return field
		}

	private fun loadProfile() {
		_text.apply {
			value = profileProvider.loadProfile()
		}
	}
}