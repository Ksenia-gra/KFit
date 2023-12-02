package com.example.kfit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kfit.R
import com.example.kfit.models.CalendarItem
import com.example.kfit.models.Product
import com.michalsvec.singlerowcalendar.utils.DateUtils

class ProductAdapter(private val items: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductAdapter.ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(
        holder: ProductAdapter.ProductViewHolder,
        position: Int
    ) {
        var productItem: Product = items[position]
        holder.image.setImageResource(R.drawable.dinner_icon_image)
        holder.productName.text = productItem.name
        holder.productCalories.text = productItem.calories.toString()
    }
    class ProductViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.productImage)
        val productName: TextView = view.findViewById(R.id.productName)
        val productCalories:TextView = view.findViewById(R.id.productCalories)
    }
}