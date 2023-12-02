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
import com.example.kfit.adapters.ProductAdapter
import com.example.kfit.adapters.TrainingAdapter
import com.example.kfit.models.Product
import com.example.kfit.models.Training

class DialogSearchMealsFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.dialog_search_meals_fragment,container,false);
        val closeBtn: Button =  view.findViewById(R.id.closeDialogMealsButton)
        val recyclerView: RecyclerView = view.findViewById(R.id.productsRecycler)
        recyclerView.adapter = ProductAdapter(setProductData())
        closeBtn.setOnClickListener(View.OnClickListener { v: View? ->
            parentFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer,MainMenuFragment()).commit()
        })
        return view
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
    }
    private fun setProductData() : List<Product> {
        val data = mutableListOf<Product>()
        (0 until 6).forEach { _ ->
            data.add(Product("Яблоко",50,null,null,null,null))
        }

        return data
    }
}