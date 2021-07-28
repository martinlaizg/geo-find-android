package com.martinlaizg.geofind.ui.profile

import com.martinlaizg.geofind.ui.view.ProfileView

class ProfileProvider {

	fun loadProfile(onSuccess: (ProfileView) -> Unit) {
		Thread {
			onSuccess(ProfileView("martinlaizg"))
		}.start()
	}
}