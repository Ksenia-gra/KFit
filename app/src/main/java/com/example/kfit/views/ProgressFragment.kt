package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kfit.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class ProgressFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.progress_fragment,container,false);
        var lineChart:LineChart = view.findViewById(R.id.progressChart)
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 5f))
        entries.add(Entry(2f, 4f))
        entries.add(Entry(3f, 4f))
        entries.add(Entry(4f, 1f))
        val dataset = LineDataSet(entries, "Прогресс пользователя")
        dataset.valueTextSize = 18f
        dataset.color = resources.getColor(R.color.secondaryAccentColor)
        dataset.lineWidth = 14f
        var colorsList:List<Int> =  listOf<Int>(resources.getColor(R.color.accentColor))
        dataset.circleColors = colorsList
        dataset.circleRadius = 10f
        val data = LineData(dataset)
        lineChart.legend.textSize=16f
        lineChart.legend.textColor = resources.getColor(R.color.mainTextColor)
        lineChart.axisLeft.setDrawLabels(false)
        lineChart.axisRight.setDrawLabels(false)
        lineChart.xAxis.setDrawLabels(false)
        lineChart.data=data
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
}