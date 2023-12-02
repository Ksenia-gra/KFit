package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kfit.R
import com.example.kfit.adapters.CalendarItemAdapter
import com.example.kfit.models.CalendarItem
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR
import java.util.Calendar.getInstance
import java.util.Date

class NutritionFragment: Fragment() {
    private val calendar = getInstance()
    private var currentMonth = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.nutrition_fragment,container,false);
        this.calendar.time = Date()
        currentMonth = this.calendar[Calendar.MONTH]
        val breakFastBtn:Button = view.findViewById(R.id.addBreakfastItem)
        breakFastBtn.setOnClickListener(View.OnClickListener { v: View? ->
           parentFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer,DialogSearchMealsFragment()).commit()
        })
        val recyclerView: RecyclerView = view.findViewById(R.id.main_single_row_calendar)
        recyclerView.adapter = CalendarItemAdapter(requireContext(), setData())
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
    private fun setData() : List<CalendarItem> {
        val data = mutableListOf<CalendarItem>()

        val today: Calendar = getInstance()
        calendar.clear()
        calendar[YEAR] = today.get(YEAR)
        calendar[MONTH] = today.get(MONTH) + 1
        calendar[DAY_OF_MONTH] = 1
        calendar.add(MONTH, 1)
        calendar.add(DAY_OF_MONTH, -1)
        val daysInMonth = calendar[DAY_OF_MONTH]
        calendar.add(DAY_OF_MONTH, -daysInMonth)

        (0 until daysInMonth).forEach { _ ->
            calendar.add(DAY_OF_MONTH, 1)
            data.add(CalendarItem(calendar.time,null))
        }

        return data
    }
}