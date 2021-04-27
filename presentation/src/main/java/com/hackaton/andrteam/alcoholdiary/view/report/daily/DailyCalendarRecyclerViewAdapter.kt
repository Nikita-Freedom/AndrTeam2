package com.hackaton.andrteam.alcoholdiary.view.report.daily

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.andrteam.alcoholdiary.R
import com.hackaton.andrteam.alcoholdiary.domain.model.CalendarDay

class DailyCalendarRecyclerViewAdapter(
    private val list: List<CalendarDay>,
    private val actionListener: (Int) -> Unit
) : RecyclerView.Adapter<DailyCalendarRecyclerViewAdapter.DailyCalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyCalendarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_calendar, parent, false)

        return DailyCalendarViewHolder(view)
    }

    override fun onBindViewHolder(holder: DailyCalendarViewHolder, position: Int) {
        holder.onBind(list[position], actionListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DailyCalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.dayCalendarNameTextView)
        private val numberTextView = itemView.findViewById<TextView>(R.id.dayCalendarNumberTextView)
        private val isDirtyFlag = itemView.findViewById<ImageView>(R.id.dayCalendarIsClearIndicator)

        fun onBind(item: CalendarDay, actionListener: (Int) -> Unit) {
            nameTextView.text = item.day.title
            numberTextView.text = item.number.toString()
            if (item.number == 14) {
                itemView.background = itemView.context.getDrawable(R.drawable.corners_calendar_day)
            } else {
                itemView.background = null
            }
            if (item.dailySessions != null) {
                isDirtyFlag.visibility = View.VISIBLE
            } else {
                isDirtyFlag.visibility = View.INVISIBLE
            }

            itemView.setOnClickListener {
                actionListener(item.number)
            }
        }
    }
}