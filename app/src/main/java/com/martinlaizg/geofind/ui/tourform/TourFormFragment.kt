package com.martinlaizg.geofind.ui.tourform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.martinlaizg.geofind.databinding.FragmentTourFormBinding
import com.martinlaizg.geofind.ui.view.TourView

/**
 *
 */
class TourFormFragment : Fragment() {

	private var _binding: FragmentTourFormBinding? = null
	private val binding get() = _binding!!

	private var viewModel = TourFormViewModel()

	/**
	 *
	 */
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View {
		_binding = FragmentTourFormBinding.inflate(inflater, container, false)
		return binding.root
	}

	/**
	 *
	 */
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.createdTour.observe(viewLifecycleOwner, {
			Toast.makeText(activity, it.name, Toast.LENGTH_LONG).show()
			Navigation.findNavController(view)
				.navigate(TourFormFragmentDirections.actionFromTourFormToTour(it.id))
		})
		viewModel.err.observe(viewLifecycleOwner, {
			Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
		})
		binding.buttonCreateTour.setOnClickListener {
			val tourView = buildTourView()
			if (tourView != null) {
				viewModel.createTour(tourView)
			}
		}
		binding.inputTextTourTitle.addTextChangedListener {
			if (it.toString().isNotEmpty()) {
				binding.layoutInputTextTourTitle.error = ""
			}
		}
		binding.inputTextTourDescription.addTextChangedListener {
			if (it.toString().isNotEmpty()) {
				binding.layoutInputTextTourDescription.error = ""
			}
		}
	}

	private fun buildTourView(): TourView? {
		var valid = true
		val title = binding.inputTextTourTitle.text.toString()
		if (title.isEmpty()) {
			binding.layoutInputTextTourTitle.error = "Title is required"
			valid = false
		}
		val description = binding.inputTextTourDescription.text.toString()
		if (description.isEmpty()) {
			binding.layoutInputTextTourDescription.error = "Description is required"
			valid = false
		}
		if (!valid) {
			return null
		}
		return TourView("", title, description)
	}

	/**
	 *
	 */
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
