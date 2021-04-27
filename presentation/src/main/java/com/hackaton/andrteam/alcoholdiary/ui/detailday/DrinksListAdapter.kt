package com.hackaton.andrteam.alcoholdiary.ui.detailday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.andrteam.alcoholdiary.R
import com.hackaton.andrteam.alcoholdiary.data.model.Drink

class DrinksListAdapter() : ListAdapter<Drink, DrinksListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_drink, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameDrink: TextView = itemView.findViewById(R.id.tvDrink)
        private val mlDrink: TextView = itemView.findViewById(R.id.tvMl)

        fun bind(drink: Drink) {
            nameDrink.text = drink.name
            mlDrink.text = drink.volume.toString() + " мл"
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem == newItem
        }
    }
}