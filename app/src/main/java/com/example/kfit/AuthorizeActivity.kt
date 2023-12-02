package com.example.kfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kfit.models.CalendarItem
import java.util.Calendar
import java.util.Date

class AuthorizeActivity : AppCompatActivity() {
    private val calendar = Calendar.getInstance()
    private var currentMonth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_fragment)

        calendar.time = Date()
        currentMonth = calendar[Calendar.MONTH]

        /*val recyclerView: RecyclerView = findViewById(R.id.main_single_row_calendar)
        recyclerView.adapter = CalendarItemAdapter(setData())*/

    }

    private fun setData() : List<CalendarItem> {
        val data = mutableListOf<CalendarItem>()
        (0..30).forEach { _ -> data.add(CalendarItem(calendar.time,null)) }
        return data
    }

}