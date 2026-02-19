package com.example.peretz.core.domain.di.model

data class CategoryModel(
    val name: String,
    val iconRes: Int,
    val meals: List<MealModel>
)