package com.martinlaizg.geofind.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.martinlaizg.geofind.databinding.FragmentProfileBinding

/**
 *
 */
class ProfileFragment : Fragment() {

	private var _binding: FragmentProfileBinding? = null
	private val binding get() = _binding!!

	private lateinit var profileViewModel: ProfileViewModel

	/**
	 *
	 */
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View {
		profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
		_binding = FragmentProfileBinding.inflate(inflater, container, false)
		val root: View = binding.root

		val textView: TextView = binding.textUsername
		profileViewModel.text.observe(viewLifecycleOwner, {
			textView.text = it.username
		})
		return root
	}

	/**
	 *
	 */
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
