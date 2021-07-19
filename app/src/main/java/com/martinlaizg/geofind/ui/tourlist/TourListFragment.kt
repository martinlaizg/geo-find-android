package com.martinlaizg.geofind.ui.tourlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.martinlaizg.geofind.databinding.FragmentTourlistBinding

class TourListFragment : Fragment() {

	private val _tag: String = TourListFragment::class.java.simpleName
	private lateinit var tourListViewModel: TourListViewModel
	private var _binding: FragmentTourlistBinding? = null

	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		tourListViewModel = ViewModelProvider(this).get(TourListViewModel::class.java)

		_binding = FragmentTourlistBinding.inflate(inflater, container, false)
		val root: View = binding.root
		tourListViewModel.data.observe(viewLifecycleOwner, {
			Log.v(_tag, "Data has changed")
			binding.viewTourList.adapter = TourListRecyclerViewAdapter(it)
		})
		return root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}