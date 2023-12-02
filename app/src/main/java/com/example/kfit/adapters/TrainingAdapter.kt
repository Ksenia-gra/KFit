package com.example.kfit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kfit.R
import com.example.kfit.models.Product
import com.example.kfit.models.Training
import org.w3c.dom.Text

class TrainingAdapter(private val items: List<Training>) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainingAdapter.TrainingViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.training_item, parent, false)
        return TrainingAdapter.TrainingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(
        holder: TrainingAdapter.TrainingViewHolder,
        position: Int
    ) {
        var trainingItem: Training = items[position]
        holder.trainingPreview.setImageResource(R.drawable.default_train_image)
        holder.trainingTitle.text = trainingItem.name
        holder.trainingType.text = trainingItem.description
    }
    class TrainingViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val trainingPreview: ImageView = view.findViewById(R.id.trainPreview)
        val trainingTitle: TextView = view.findViewById(R.id.trainItemTitle)
        val trainingType: TextView = view.findViewById(R.id.trainingType)
        val isDone:TextView = view.findViewById(R.id.trainingIsDone)
    }
}