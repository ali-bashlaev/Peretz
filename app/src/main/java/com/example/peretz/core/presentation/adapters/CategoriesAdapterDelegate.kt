package com.example.peretz.core.presentation.adapters

import com.example.peretz.core.domain.di.model.CategoryModel
import com.example.peretz.databinding.ItemCategoryBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun categoriesAdapterDelegate() =
    adapterDelegateViewBinding<CategoryModel, CategoryModel, ItemCategoryBinding>(
        { layoutInflater, parent -> ItemCategoryBinding.inflate(layoutInflater, parent, false) }
    ) {
        bind {
            binding.homeCategoryName.text = item.name
            binding.homeCategoryIcon.setImageResource(item.iconRes)
        }
    }