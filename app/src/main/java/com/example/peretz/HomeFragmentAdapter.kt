package com.example.peretz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.core.domain.di.model.MealModel
import com.example.peretz.databinding.MealModelBinding

class HomeFragmentAdapter(
    private val meals: List<MealModel> // Add constructor parameter
) : RecyclerView.Adapter<HomeFragmentAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MealModelBinding.inflate(inflater, parent, false)
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
        val binding: MealModelBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    }
}
