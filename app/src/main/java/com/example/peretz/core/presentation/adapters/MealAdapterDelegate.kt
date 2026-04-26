package com.example.peretz.core.presentation.adapters

import com.example.peretz.core.domain.di.model.MealModel
import com.example.peretz.databinding.ItemMealBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun mealAdapterDelegate() =
    adapterDelegateViewBinding<MealModel, MealModel, ItemMealBinding>(
        { layoutInflater, parent -> ItemMealBinding.inflate(layoutInflater, parent, false) }
    ) {
        bind {
            binding.mealModelNameText.text = item.name
            binding.mealModelDescriptionText.text = item.description
            binding.mealModelCoverImage.setImageResource(item.image)
            binding.mealModelPriceText.text = item.price.toString()
        }
    }