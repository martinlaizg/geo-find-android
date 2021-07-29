package com.martinlaizg.geofind.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.martinlaizg.geofind.databinding.FragmentHomeBinding

/**
 * TODO
 *
 */
class HomeFragment : Fragment() {

	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!

	/**
	 * TODO
	 *
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 * @return
	 */
	@SuppressLint("SetTextI18n")
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		binding.textHome.text = "Home"
		return binding.root
	}

	/**
	 * TODO
	 *
	 */
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
