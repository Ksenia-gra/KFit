package com.example.kfit.views

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.kfit.R

class SelectTargetFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.target_select_start_fragment,container,false);
        val futherTarget: Button = view.findViewById(R.id.futherTarget)
        var cardLooseWeignt:CardView = view.findViewById(R.id.weightLostCard)
        var cardGainWeignt:CardView = view.findViewById(R.id.weightLostCard)

        futherTarget.setOnClickListener(View.OnClickListener { v: View? ->
            parentFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer,SelectGenderFragment()).commit()
        })

        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
}