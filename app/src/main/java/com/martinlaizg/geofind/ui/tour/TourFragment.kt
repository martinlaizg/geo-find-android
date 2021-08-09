package com.martinlaizg.geofind.ui.tour

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.martinlaizg.geofind.R
import com.martinlaizg.geofind.databinding.FragmentTourBinding
import com.martinlaizg.geofind.ui.view.TourView

/**
 *
 */
class TourFragment : Fragment() {

	private val _tag = TourFragment::class.java.simpleName
	private val args: TourFragmentArgs by navArgs()

	private var _binding: FragmentTourBinding? = null
	private val binding get() = _binding!!

	private val viewModel by lazy { TourViewModel(args.id) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setHasOptionsMenu(true)
	}

	/**
	 *
	 */
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View {
		_binding = FragmentTourBinding.inflate(inflater, container, false)
		viewModel.data.observe(viewLifecycleOwner, {
			setUpView(it)
		})
		viewModel.err.observe(viewLifecycleOwner, {
			Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
		})
		return binding.root
	}

	private fun setUpView(view: TourView) {
		binding.textTourName.text = view.name
		binding.textTourDescription.text = view.description
	}

	/**
	 *
	 */
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	/**
	 * Inflate menu options
	 */
	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		inflater.inflate(R.menu.tour_fragment_menu, menu)
		super.onCreateOptionsMenu(menu, inflater)
	}

	/**
	 * Menu option selected
	 */
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.delete_tour_menu_item -> {
				viewModel.removeTour()
				if (parentFragmentManager.backStackEntryCount > 0) {
					Log.d(_tag, "Pop backstack")
					parentFragmentManager.popBackStack()
				} else {
					Log.d(_tag, "nothing can pop")
				}
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}
}
