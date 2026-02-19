package com.example.peretz.core.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.core.domain.di.model.CategoryModel
import com.example.peretz.databinding.ItemCategoryBinding

class CategoriesAdapter(
    private val categories: List<CategoryModel>
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoriesViewHolder,
        position: Int
    ) {
        val category = categories[position]
        with(holder.binding) {
            homeCategoryName.text = category.name
            homeCategoryIcon.setImageResource(category.iconRes)
        }
    }

    override fun getItemCount(): Int = categories.size

    class CategoriesViewHolder(
        val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root)
}