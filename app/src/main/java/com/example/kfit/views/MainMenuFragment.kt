package com.example.kfit.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kfit.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainMenuFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.main_menu_fragment,container,false);
        val bottomNavMenu: BottomNavigationView=view.findViewById(R.id.bottomNavigationView)
        val accountButton: Button = view.findViewById(R.id.toAccountPage)
        bottomNavMenu.selectedItemId = R.id.nutritionPage
        parentFragmentManager
            .beginTransaction()
            .add(R.id.fragment, NutritionFragment())
            .commit()
        accountButton.setOnClickListener(View.OnClickListener { v:View?->
            parentFragmentManager.beginTransaction().replace(R.id.fragment,AccountFragment()).commit()
        })
        bottomNavMenu.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nutritionPage -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, NutritionFragment())
                        .commit()
                    return@OnItemSelectedListener true
                }

                R.id.progressPage -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, ProgressFragment())
                        .commit()
                    return@OnItemSelectedListener true
                }

                R.id.trainingsPage -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, TrainingFragment())
                        .commit()
                    return@OnItemSelectedListener true
                }
            }
            false
        })
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
}