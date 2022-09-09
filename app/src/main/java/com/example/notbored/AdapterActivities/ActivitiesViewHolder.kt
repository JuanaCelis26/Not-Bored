package com.example.notbored.AdapterActivities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.ItemActivitiesBinding
/**
 * viewholder is the binding of activity items
 **/
class ActivitiesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = ItemActivitiesBinding.bind(view)
    fun OnBind(itemPosition: String) {
        binding.tvItemActivities.text = itemPosition

    }
}