package com.example.peretz.core.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.core.domain.di.model.MealModel
import com.example.peretz.databinding.ItemMealBinding

class MealAdapter(
    private val meals: List<MealModel> // Add constructor parameter
) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMealBinding.inflate(inflater, parent, false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MealViewHolder,
        position: Int
    ) {
        val meal = meals[position]
        with(holder.binding) {
            mealModelNameText.text = meal.name
            mealModelDescriptionText.text = meal.description
            mealModelCoverImage.setImageResource(meal.image)
            mealModelPriceText.text = meal.price.toString()
        }
    }

    override fun getItemCount(): Int = meals.size

    class MealViewHolder(
        val binding: ItemMealBinding
    ) : RecyclerView.ViewHolder(binding.root)
}