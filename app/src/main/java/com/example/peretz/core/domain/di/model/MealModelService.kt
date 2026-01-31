package com.example.peretz.core.domain.di.model

typealias MealModelListener = (meals: List<MealModel>) -> Unit


class MealModelService {

    private var meals = mutableListOf<MealModel>()

    private var listeners = mutableSetOf<MealModelListener>()

    fun getMeals(): List<MealModel> {
        return meals
    }

    fun addListener(listener: MealModelListener) {
        listeners.add(listener)
        listener.invoke(meals)
    }

    fun removeListener(listener: MealModelListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(meals) }
    }
}