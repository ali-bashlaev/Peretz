package com.example.peretz.core.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.core.domain.di.model.SaleModel
import com.example.peretz.databinding.ItemSaleBinding

class SaleAdapter(
    private val sales: List<SaleModel>
) : RecyclerView.Adapter<SaleAdapter.SaleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SaleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSaleBinding.inflate(inflater, parent, false)
        return SaleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SaleViewHolder,
        position: Int
    ) {
        val sale = sales[position]
        with(holder.binding) {
            itemSaleImage.setImageResource(sale.image)
        }
    }

    override fun getItemCount(): Int = sales.size

    class SaleViewHolder(
        val binding: ItemSaleBinding
    ) : RecyclerView.ViewHolder(binding.root)
}