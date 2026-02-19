package com.example.peretz.core.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.peretz.R
import com.example.peretz.core.domain.di.model.CategoryModel
import com.example.peretz.core.domain.di.model.MealModel
import com.example.peretz.core.domain.di.model.SaleModel
import com.example.peretz.core.presentation.navigation.Screens
import com.example.peretz.databinding.FragmentHomeBinding
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import me.aartikov.alligator.Navigator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val navigator: Navigator = NavigationControllerHolder.requireNavigator()

    private lateinit var mealsRecyclerView: RecyclerView
    private lateinit var salesRecyclerView: RecyclerView
    private lateinit var categoriesRecyclerView: RecyclerView

    private lateinit var pagerIndicatorHorizontal: IndefinitePagerIndicator

    val salads = listOf(
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
        SaleModel(R.drawable.img_roll),
        SaleModel(R.drawable.img_pizza),
        SaleModel(R.drawable.img_roll),
        SaleModel(R.drawable.img_pizza)
    )

    val categories = listOf(
        CategoryModel(name = "Роллы", iconRes = R.drawable.ic_roll, meals = emptyList()),
        CategoryModel(name = "Пицца", iconRes = R.drawable.ic_pizza, meals = emptyList()),
        CategoryModel(name = "Cалаты", iconRes = R.drawable.ic_salad, meals = salads),
        CategoryModel(name = "Бургеры", iconRes = R.drawable.ic_burger, meals = emptyList())
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val snapHelper = PagerSnapHelper()

        _binding = FragmentHomeBinding.bind(view)

        pagerIndicatorHorizontal = binding.salesRecyclerviewIndicator

        salesRecyclerView = binding.salesHomeList
        mealsRecyclerView = binding.mealsHomeList
        categoriesRecyclerView = binding.categoriesHomeList

        salesRecyclerView.adapter = SaleAdapter(sales) { navigator.goForward(Screens.Sale) }
        mealsRecyclerView.adapter = MealAdapter(salads)
        categoriesRecyclerView.adapter = CategoriesAdapter(categories)

        snapHelper.attachToRecyclerView(salesRecyclerView)
        pagerIndicatorHorizontal.attachToRecyclerView(salesRecyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}