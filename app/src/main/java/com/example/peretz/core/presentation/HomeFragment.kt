package com.example.peretz.core.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.R
import com.example.peretz.core.domain.di.model.MealModel
import com.example.peretz.core.domain.di.model.SaleModel
import com.example.peretz.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mealsRecyclerView: RecyclerView
    private lateinit var salesRecyclerView: RecyclerView


    val meals = listOf(
        MealModel(
            "Цезарь классический\n" +
                    "с романо", "Листья романо, маринованное куриное филе, черри,\n" +
                    "ароматные сухарики,заправленные соусом цезарь, посыпанное стружкой сыра пармезан",
            345, R.drawable.caesar_salad
        ),
        MealModel(
            "Салат Бангок ХИТ",
            "Обжаренное куриное филе, отварная морковь,\n" +
                    "яйца, маринованный лук, майонез",
            345, R.drawable.bangkok_salad
        )
    )

    val sales = listOf(
        SaleModel(R.drawable.img_sale),
        SaleModel(R.drawable.img_sale_pizza)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        mealsRecyclerView = binding.mealsHomeList
        mealsRecyclerView.adapter = MealAdapter(meals)

        salesRecyclerView = binding.salesHomeList
        salesRecyclerView.adapter = SaleAdapter(sales)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}