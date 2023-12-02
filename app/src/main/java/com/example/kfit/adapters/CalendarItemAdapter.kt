package com.example.kfit.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kfit.R
import com.example.kfit.models.CalendarItem
import com.michalsvec.singlerowcalendar.utils.DateUtils

class CalendarItemAdapter(private val context : Context, private val items: List<CalendarItem>) : RecyclerView.Adapter<CalendarItemAdapter.CalendarItemViewHolder>() {
    private var  selectedPosition = -1
    private var selectedCard : CardView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item, parent, false)
        return CalendarItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CalendarItemViewHolder, position: Int) {
        var calendarItem: CalendarItem = items[position]
        holder.calDate.text =  DateUtils.getDay3LettersName(calendarItem.date)
        holder.calDay.text = DateUtils.getDayNumber(calendarItem.date)

        if (selectedPosition == holder.adapterPosition)
        {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.mainBlueColor))
        }
        else
        {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.mainElementsColor))
        }

        holder.cardView.setOnClickListener {
            val previousPosition = selectedPosition
            if (selectedCard != null)
            {
                selectedCard!!.setCardBackgroundColor(ContextCompat.getColor(context, R.color.mainElementsColor))
            }

            notifyItemChanged(previousPosition)
            selectedCard = holder.cardView
            selectedPosition = holder.adapterPosition
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.accentColor))
            notifyItemChanged(selectedPosition)
        }
    }

    class CalendarItemViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val calDate: TextView = view.findViewById(R.id.tv_date_calendar_item)
        val calDay: TextView = view.findViewById(R.id.tv_day_calendar_item)
        val cardView:CardView = view.findViewById(R.id.cl_calendar_item)
    }
}