package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kfit.R

class AccountFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.account_fragment,container,false);
        val exitButton:Button = view.findViewById(R.id.exitFromAccountBtn)
        exitButton.setOnClickListener(View.OnClickListener { v:View?->
            parentFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer,AuthentificationFragment()).commit()
        }
        )
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
}