package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kfit.R
import com.example.kfit.adapters.CalendarItemAdapter
import com.example.kfit.adapters.TrainingAdapter
import com.example.kfit.models.CalendarItem
import com.example.kfit.models.Training
import java.util.Calendar
import java.util.Date

class TrainingFragment: Fragment() {
    private val calendar = Calendar.getInstance()
    private var currentMonth = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.trainings_fragment,container,false);
        this.calendar.time = Date()
        currentMonth = this.calendar[Calendar.MONTH]
        val recyclerView: RecyclerView = view.findViewById(R.id.single_row_trainings_calendar)
        val trainingsRecyclerView: RecyclerView = view.findViewById(R.id.trainings_recycler)
        recyclerView.adapter = CalendarItemAdapter(requireContext(), setData())
        trainingsRecyclerView.adapter = TrainingAdapter(setTrainingData())
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
    private fun setData() : List<CalendarItem> {
        val data = mutableListOf<CalendarItem>()

        val today: Calendar = Calendar.getInstance()
        calendar.clear()
        calendar[Calendar.YEAR] = today.get(Calendar.YEAR)
        calendar[Calendar.MONTH] = today.get(Calendar.MONTH) + 1
        calendar[Calendar.DAY_OF_MONTH] = 1
        calendar.add(Calendar.MONTH, 1)
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val daysInMonth = calendar[Calendar.DAY_OF_MONTH]
        calendar.add(Calendar.DAY_OF_MONTH, -daysInMonth)

        (0 until daysInMonth).forEach { _ ->
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            data.add(CalendarItem(calendar.time,null))
        }

        return data
    }
    private fun setTrainingData() : List<Training> {
        val data = mutableListOf<Training>()
        (0 until 6).forEach { _ ->
            data.add(Training("Разминка","Тренировка на все тело",null))
        }

        return data
    }
}