package com.martinlaizg.geofind.ui.tourlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.martinlaizg.geofind.databinding.FragmentTourlistBinding

/**
 *
 */
class TourListFragment : Fragment() {

	private var _binding: FragmentTourlistBinding? = null
	private val binding get() = _binding!!

	private var viewModel = TourListViewModel()
	private lateinit var adapter: TourListRecyclerViewAdapter

	/**
	 *
	 */
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View {
		_binding = FragmentTourlistBinding.inflate(inflater, container, false)

		viewModel.err.observe(viewLifecycleOwner, {
			Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
		})
		adapter = TourListRecyclerViewAdapter()
		binding.viewTourList.adapter = adapter
		viewModel.data.observe(viewLifecycleOwner, {
			adapter.dataSet = it
		})

		return binding.root
	}

	/**
	 *
	 */
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.buttonAddTour.setOnClickListener(Navigation.createNavigateOnClickListener(
			TourListFragmentDirections.actionFromTourListToTourForm()))
	}

	/**
	 *
	 */
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
