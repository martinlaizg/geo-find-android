package com.martinlaizg.geofind.ui.tourlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.martinlaizg.geofind.databinding.FragmentTourlistItemBinding

class TourListAdapter(private val dataSet: Array<TourView>) :
	RecyclerView.Adapter<TourListAdapter.ViewHolder>() {

	private val _tag: String = TourListAdapter::class.java.simpleName

	class ViewHolder(private val binding: FragmentTourlistItemBinding) :
		RecyclerView.ViewHolder(binding.root) {
		private val _tag: String =
			TourListAdapter::class.java.simpleName + ViewHolder::class.java.simpleName

		fun bind(tourView: TourView) {
			binding.textTourTitle.text = tourView.title
			if (tourView.image.isBlank()) {
				binding.imageTour.visibility = View.GONE
			} else {
				try {
					Glide.with(binding.root).load(tourView.image).into(binding.imageTour)
				} catch (e: GlideException) {
					e.logRootCauses(_tag)
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		Log.v(_tag, "Create ViewHolder")
		return ViewHolder(
			FragmentTourlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(dataSet[position])
	}

	override fun getItemCount() = dataSet.size

}