package com.example.notbored.AdapterActivities

import android.os.IInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.Activities
import com.example.notbored.AdapterActivities.Interfaces.ClickItem
import com.example.notbored.R

class AdapterActivities(private val listActivities: List<String>, val call : ClickItem) : RecyclerView.Adapter<ActivitiesViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActivitiesViewHolder(layoutInflater.inflate(R.layout.item_activities, parent, false))
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val itemPosition = listActivities[position]
        holder.OnBind(itemPosition)
        holder.itemView.setOnClickListener{
            call.clickItem(itemPosition)
        }
    }

    override fun getItemCount(): Int = listActivities.size
}