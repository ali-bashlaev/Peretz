package com.example.peretz.core.presentation.adapters

import com.example.peretz.core.domain.di.model.SaleModel
import com.example.peretz.databinding.ItemSaleBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun saleAdapterDelegate(onClick: (SaleModel) -> Unit) =
    adapterDelegateViewBinding<SaleModel, SaleModel, ItemSaleBinding>(
        { layoutInflater, parent -> ItemSaleBinding.inflate(layoutInflater, parent, false) }
    ) {
        bind {
            binding.itemSaleImage.setImageResource(item.image)
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }