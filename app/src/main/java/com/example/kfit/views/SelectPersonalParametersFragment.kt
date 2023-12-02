package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kfit.R

class SelectPersonalParametersFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.select_personalparameters_fragment,container,false);
        val futherParameters: Button = view.findViewById(R.id.futherPersonalParameters)
        futherParameters.setOnClickListener(View.OnClickListener { v: View? ->
            parentFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer,MainMenuFragment()).commit()
        })
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
}