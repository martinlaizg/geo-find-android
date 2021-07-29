package com.martinlaizg.geofind.ui.tourlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.martinlaizg.geofind.databinding.FragmentTourlistItemBinding
import com.martinlaizg.geofind.ui.view.TourView

/**
 * TODO
 *
 */
class TourListRecyclerViewAdapter : RecyclerView.Adapter<TourListRecyclerViewAdapter.ViewHolder>() {

	/**
	 *
	 */
	var dataSet: List<TourView> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	/**
	 * TODO
	 *
	 * @property binding
	 */
	class ViewHolder(private val binding: FragmentTourlistItemBinding) :
		RecyclerView.ViewHolder(binding.root) {

		/**
		 * TODO
		 *
		 * @param tourView
		 */
		fun bind(tourView: TourView) {
			binding.cardTour.setOnClickListener {
				Navigation.findNavController(it)
					.navigate(TourListFragmentDirections.actionFromTourListToTour(tourView.id))
			}
			binding.textTourTitle.text = tourView.name
			if (tourView.image?.isBlank() == true) {
				binding.imageTour.visibility = View.GONE
			} else {
				Glide.with(binding.root).load(tourView.image).into(binding.imageTour)
			}
		}
	}

	/**
	 * TODO
	 *
	 * @param parent
	 * @param viewType
	 * @return
	 */
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(
			FragmentTourlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
	}

	/**
	 * TODO
	 *
	 * @param holder
	 * @param position
	 */
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(dataSet[position])
	}

	/**
	 * TODO
	 *
	 */
	override fun getItemCount() = dataSet.size
}
